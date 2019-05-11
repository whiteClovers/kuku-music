<template>
  <div>
    <Row justify="center" align="middle" style="margin-top: 25px">
      <Col span="16" offset="4">
        <Layout>
          <Sider hide-trigger :style="{background: '#fff'}">
            <Menu theme="light" width="auto" :open-names="['1']">
              <Submenu name="1">
                <template slot="title">
                  <Icon type="ios-musical-notes"/>
                  我的歌单
                </template>
                <MenuItem name="item.listName" v-for="item in musicListData" :key="item.listId">
                  <span @click="loadMusicListSongs(item.listId)">{{item.listName}}</span>
                </MenuItem>
              </Submenu>
            </Menu>
          </Sider>
          <Layout>
            <Content style="padding: 20px">

              <div>
                <Row>
                  <Col span="6">
                    <img :src="curMusicList.listPic" style="height: 200px;height: 200px;"/>
                  </Col>
                  <Col span="18">
                    <h1 >
                      <Tag color="cyan">歌单</Tag>
                      {{curMusicList.listName}}
                    </h1>

                    <h3 style="margin-top: 15px">创建于 {{curMusicList.creaTime|dateFmt}}</h3>
                    <h3 style="margin-top: 15px">
                      标签：<Tag type="border" color="primary">{{curMusicList.label}}</Tag>
                    </h3>
                  </Col>
                </Row>


              </div>

              <aplayer
                ref="aplayer"
                :audio="audio"
                :volume.sync="volume"
                :lrcType="1"
                :listMaxHeight="500"

                @update:volume="updateVolume"
                @onListSwitch="onListSwitch"
                @onEnded="onEnded"
                @onPause="onPause"
                @onPlaying="onPlaying"
                @lrcShow="lrcShow"
                @lrcHide="lrcHide"

              />
            </Content>
          </Layout>
        </Layout>
      </Col>
    </Row>
  </div>
</template>

<script>

  export default {
    name: 'MusicList',
    components: {},
    data() {
      return {
        theme: 'light',
        curMusicList: {},
        musicListData: [],
        audio: [
          {
            name: '东西（Cover：林俊呈）',
            artist: '纳豆',
            url: 'https://cdn.moefe.org/music/mp3/thing.mp3',
            cover: 'https://p1.music.126.net/5zs7IvmLv7KahY3BFzUmrg==/109951163635241613.jpg?param=300y300',
            lrc: 'https://cdn.moefe.org/music/lrc/thing.lrc',
          }
        ],
        volume: 0.7,
        timeoutflag: null,
      };
    },
    mounted() {
      this.loadMusicListInfo()
    },
    methods: {
      loadMusicListInfo(id) {
        this.$http.get('/music/musicList').then(res => {
          this.musicListData = res.data.data
          this.loadMusicListSongs(this.musicListData[0].listId)
        })
      },
      loadSingleMusicListInfo(id) {
        this.$http.get('/music/musicList/' + id).then(res => {
          console.log(res.data)
          this.curMusicList = res.data.data

        })
      },
      loadMusicListSongs(id) {
        this.$Notice.info({
          title: '正在获取歌单内容',
          desc: '',
          duration: 1
        });
        this.loadSingleMusicListInfo(id)
        this.$http.get('/music/musicList/songs/' + id).then(res => {
          this.audio = res.data.data
        })
      },


      //播放器修改
      updateVolume() {
        if (this.timeoutflag != null) {
          clearTimeout(this.timeoutflag);
        }
        this.timeoutflag = setTimeout(() => {
          this.$Message.info('播放器音量修改为 ' + Number(this.volume * 100).toFixed(0) + ' %')
          console.log(this.$refs.aplayer.currentMusic);
        }, 800)
      },
      onListSwitch() {
        this.$Message.info('切换歌曲')
      },
      onEnded() {
        this.$Message.info('播放完成')
      },
      onPlaying() {
        this.$Message.info('正在播放xx')
      },
      onPause() {
        this.$Message.info('音乐暂停')
      },
      lrcShow() {
        this.$Message.info('歌词打开')
      },
      lrcHide() {
        this.$Message.info('歌词关闭')
      }
    }
  };
</script>
<style>

</style>
