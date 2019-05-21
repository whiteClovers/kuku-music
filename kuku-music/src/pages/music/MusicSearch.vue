<template>
  <Row justify="center" align="middle" style="margin-top: 25px">
    <Col span="16" offset="4">
      <div class="movieSearch">
        <div class="certain-category-search-wrapper searchBox" style="width: auto;float: left;">
          <AutoComplete
            v-model="searchInput"
            size="large"
            style="width: 100%"
            placeholder="输入歌曲名或者歌手名..."
            optionLabelProp="value"
            @on-blur="musicSearch"
          >
          </AutoComplete>
        </div>
      </div>

      <div class="musicList">
        <!--<div  v-show="showLoading">-->
          <!--<Spin fix>-->
            <!--<Icon type="ios-loading" size=18 class="demo-spin-icon-load"></Icon>-->
            <!--<div>加載中。。</div>-->
          <!--</Spin>-->
        <!--</div>-->
        <div class="dataResult" v-show="this.songCount!==null">
          为您找到关于“{{searchInput}}”的结果共 {{songCount}} 个
        </div>
        <div>

          <Card style="width:366px;float: left;margin: 20px" v-for="item in listData" :key="item.id">
            <div style="text-align:center">
              <img style="height: 320px;width: 280px" :src="item.album.blurPicUrl">
              <p slot="title">歌曲名：{{item.name}} </p>
              <p slot="title">歌手名：{{item.artists[0].name}} </p>
              <p :description="item.album.name"></p>

              <div>
                <p>时长: {{item.duration | timeFmt}}</p>
                <p>出品公司: {{item.album.company}}</p>
                <p>发行时间: {{item.album.publishTime | dateFmt}}</p>
                <iframe frameborder="no" border="0" marginwidth="0" marginheight="0" width=298 height=52
                        :src="'//music.163.com/outchain/player?type=2&id='+item.id+'&auto=0&height=32'"></iframe>

                <!--<Button @click="setModal1Visible(true),loadMusicCommentList(item.commentThreadId)">-->
                  <!--查看歌曲评论-->
                <!--</Button>-->

                <Button @click="loadMusicListInfo(item.id)">
                  添加到歌单
                </Button>
              </div>
            </div>
          </Card>

        </div>


        <Modal
          v-model="addMusicModal"
          title="Common Modal dialog box title"
          okText="添加歌曲到歌单"
          cancelText="取消"
          @on-ok="addMusic2DB"

        >
          <RadioGroup v-model="musicListId" vertical>
            <Radio :label="item.listId" v-for="item in musicListData" :key="item.listId">
              <span>{{item.listName}}</span>
            </Radio>
          </RadioGroup>
        </Modal>


        <!--    <a-modal-->
        <!--      title="歌曲评论"-->
        <!--      style="top: 56px;"-->
        <!--      :visible="modal1Visible"-->
        <!--      :footer="null"-->
        <!--      @ok="() => setModal1Visible(false)"-->
        <!--      @cancel="() => setModal1Visible(false)"-->
        <!--    >-->
        <!--      <a-spin :spinning="commentLoading">-->
        <!--        <div>-->
        <!--          <strong :style="{ marginRight: 8 }">共有 {{this.commentTotal}} 条评论</strong>-->
        <!--          <a-pagination-->
        <!--            style="float: right"-->
        <!--            size="small"-->
        <!--            v-model="comentPageNum"-->
        <!--            :pageSize.sync="comentPageSize"-->
        <!--            :total="commentTotal"-->
        <!--            @change="changeCommentList"-->
        <!--            @showSizeChange="changeCommentList"-->
        <!--          />-->
        <!--        </div>-->
        <!--        <a-divider/>-->
        <!--        <div>-->
        <!--          <a-list-->
        <!--            class="comment-list"-->
        <!--            itemLayout="horizontal"-->
        <!--            :dataSource="commentData"-->
        <!--          >-->
        <!--            <a-list-item slot="renderItem" slot-scope="item, index">-->

        <!--              <a-comment>-->
        <!--                <template slot="actions">-->
        <!--                    <span>-->
        <!--                      <a-tooltip title="评论点赞数">-->
        <!--                        <a-icon type="like"/>-->
        <!--                      </a-tooltip>-->
        <!--                      <span> {{item.likedCount}} </span>-->
        <!--                    </span>-->
        <!--                </template>-->
        <!--                <a slot="author">{{item.user.nickname}}</a>-->
        <!--                <a-avatar-->
        <!--                  size="large"-->
        <!--                  :src="item.user.avatarUrl"-->
        <!--                  alt="mirror"-->
        <!--                  slot="avatar"-->
        <!--                />-->
        <!--                <p slot="content">{{item.content}}</p>-->
        <!--                <span slot="datetime">{{item.time | dateFmt}}</span>-->
        <!--              </a-comment>-->
        <!--            </a-list-item>-->

        <!--          </a-list>-->
        <!--        </div>-->
        <!--      </a-spin>-->
        <!--    </a-modal>-->
      </div>

      <!--分页条-->
      <div class="page" v-show="total!==0">
        <Page
          :current="pageNum"
          :total="total"
          :page-size="pageSize"
          @on-change="changeMusicList"
          @on-page-size-change="changeMusicList"
          simple
        />
      </div>
    </Col>
  </Row>


</template>
<script>

  export default {
    name: 'CloudMusic',
    components: {},
    data() {
      return {
        // 是否显示loading
        showLoading: false,

        searchInput: '',
        pageNum: 1,
        pageSize: 12,
        total: 0,
        songCount: null,
        //当前歌单id
        musicListId: null,
        curaddMusicId: null,
        //歌单data
        musicListData: [],
        //添加歌单
        addMusicModal: false,
        loading: false,
        searchDataSource: [],
        listData: [],
        commentData: [],
        //评论模态框
        modal1Visible: false,
        //评论加载中
        commentLoading: true,
        //歌曲评论相关---start---
        curCommentId: null,
        comentPageNum: 1,
        comentPageSize: 10,
        commentTotal: 0,
        //歌曲评论相关---end---
        timeoutflag: null,

      }
    },
    methods: {
      setModal1Visible(flag) {
        this.modal1Visible = flag
        this.comentPageNum = 1
        this.comentPageSize = 10
      },
      musicSearch() {
        this.loadMusicSearchList(null, null)
        this.pageNum = 1
      },

      /*获取音乐搜索结果*/
      loadMusicSearchList() {
        this.showLoading = true
        this.$Spin.show();
        // alert('aa')
        console.log(this.pageNum, this.pageSize)
        this.$http.paramsGet('/music/search', {
          pageNum: (this.pageNum - 1) * this.pageSize,
          pageSize: this.pageSize,
          s: this.searchInput,
          type: 1,
        }).then(res => {
          console.log(res)
          let data = res.data.data
          this.listData = data.result.songs
          this.total = data.result.songCount
          this.songCount = data.result.songCount
          this.$Spin.hide();
          if (data.result === 'ok') {
            this.$Notice.success({

            });

          }
        })
      },
      loadMusicCommentList(id, pageNum, pageSize) {
        this.commentLoading = true
        this.curCommentId = id
        pageNum = (pageNum == null ? 0 : pageNum)
        pageSize = (pageSize == null ? 10 : pageSize)
        this.$http.paramsGet('/music/comment', {
          id: id,
          pageNum: pageNum,
          pageSize: pageSize,
        }).then(res => {
          let data = res.data.data
          this.commentData = data.comments
          this.commentTotal = data.total
          this.commentLoading = false
        })
      },
      loadMusicListInfo(id) {
        this.addMusicModal = true
        this.curaddMusicId = id
        this.$http.get('/music/musicList').then(res => {
          console.log(res)
          this.musicListData = res.data.data
        })
      },
      addMusic2DB() {
        this.$http.post('/music/addmusic', {
          musicId: this.curaddMusicId,
          musicListId: this.musicListId
        }).then(res => {
          // 执行某些操作
          this.loading = false
          let data = res.data.data
          console.log(data)
          this.$Notice.success({
            title: '添加歌曲',
            desc: data,
          });
        }).catch((error) => {
          this.$Notice.error({
            title: '很抱歉',
            desc: '失败!',
          });
        })
      },
      changeMusicList(curPageNum) {
        this.pageNum = curPageNum
        this.loadMusicSearchList()
      },
      changeCommentList(pageNum, pageSize) {
        this.loadMusicCommentList(this.curCommentId, pageNum, pageSize)
      }
    },
    mounted() {
      // this.loadMusicSearchList(this.pageNum, this.pageSize, this.searchInput)
    },
  }
</script>

<style scoped>
  .movieSearch {
    width: 100%;
    height: 200px;
    max-height: 300px;
    background-color: rgba(255, 255, 255, 0.13);
    display: flex;
    align-items: center;
  }

  .searchBox {
    margin: 0 auto;
    min-width: 600px;
  }

  .musicList {
    background-color: rgba(244, 244, 244, 0.26);
    padding: 15px;
  }

  .dataResult {
    font-weight: 600;
    margin-bottom: 20px;
    padding: 10px;
    position: absolute;
    right: 10px;
    top: 10px;
  }

  .page {
    font-weight: 600;
    margin-bottom: 20px;
    padding: 10px;
    position: absolute;
    right: 10px;
    top: 145px;
  }

  .demo-spin-icon-load{
    animation: ani-demo-spin 1s linear infinite;
  }
  @keyframes ani-demo-spin {
    from { transform: rotate(0deg);}
    50%  { transform: rotate(180deg);}
    to   { transform: rotate(360deg);}
  }
  .demo-spin-col{
    /*height: 10px;*/
    /*position: relative;*/
    /*border: 1px solid #eee;*/

    float: left;
    margin-left: 180px;
    margin-top: 100px;
  }


</style>
