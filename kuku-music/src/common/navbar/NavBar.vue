<template>
  <div>
    <!--顶部导航栏-->
    <div class="navbar">
      <a-menu
        mode="horizontal"
        :theme="this.mirrorTheme"
      >
        <a-menu-item key="mirrorming" @click="CLeftDrawer">
          <span id="mirrorming">mirrorming</span>
        </a-menu-item>

        <a-menu-item key="mail">
          <router-link to="/">
            <span><i class="iconfont">&#xe651;</i>首页</span>
          </router-link>
        </a-menu-item>

        <a-sub-menu>
          <span slot="title" class="submenu-title-wrapper"><i class="iconfont">&#xe76a;</i>目录</span>
          <a-menu-item v-for="category in allCategory" :key="category.id" @click="toCategory(category.id)">
            {{category.categoryName}}
          </a-menu-item>
        </a-sub-menu>

        <a-menu-item key="Archives">
          <router-link to="/archives">
            <span><i class="iconfont">&#xe710;</i>归档</span>
          </router-link>
        </a-menu-item>


        <!--<a-menu-item key="comments">-->
        <!--<router-link to="/comments">-->
        <!--<span>留言板</span>-->
        <!--</router-link>-->
        <!--</a-menu-item>-->

        <a-menu-item key="cloudmusic">
          <router-link to="/cloudmusic">
            <span><i class="iconfont">&#xe627;</i>音乐</span>
          </router-link>
        </a-menu-item>

        <a-menu-item key="movie">
          <router-link to="/movie">
            <span><i class="iconfont">&#xe639;</i>电影</span>
          </router-link>
        </a-menu-item>

        <a-menu-item key="picture">
          <router-link to="/picture">
            <span><i class="iconfont">&#xe64e;</i>图片</span>
          </router-link>
        </a-menu-item>

        <a-menu-item key="topDrawer" @click="CTopDrawer">
          <span><i class="iconfont">&#xe642;</i>网站</span>
        </a-menu-item>

        <a-menu-item key="about">
          <router-link to="/about">
            <span><i class="iconfont">&#xe624;</i>关于</span>
          </router-link>
        </a-menu-item>


        <!--右侧-->
        <!--二维码-->
        <a-popover placement="bottomRight">
          <template slot="content">
            <div style="text-align: center">手机扫码即可访问此页面</div>
            <vue-q-art :config='config'></vue-q-art>
          </template>
          <a-button class="mirror-btn" shape="circle">
            <a-icon type="scan"/>
          </a-button>
        </a-popover>
        <!--右侧设置-->
        <a-button class="mirror-btn" shape="circle" @click="CRightDrawer">
          <a-icon type="setting" theme="filled"/>
        </a-button>

        <!--全文搜索-->
        <a-auto-complete
          v-model="searchInput"
          class="mirror-search"
          dropdownClassName="mirror-search-dropdown"
          :dropdownMatchSelectWidth="false"
          placeholder="输入文章的标题/摘要/内容进行检索..."
          optionLabelProp="value"
          @focus="searchFocus"
          @blur="searchBlur"
          @change="loadSearchData"
          :open="dropdownState"
        >
          <template slot="dataSource" class="searchSelectOpt">
            <a-select-option v-for="item in searchDataSource" :key="item.id" :value="item.result">
              <span class="selectItem" v-html="item.htmlResult" @click="view(item.id)"></span>
            </a-select-option>
            <a-select-option disabled key="11">
              <a :href="'https://www.baidu.com/s?wd='+this.searchInput"
                 target="_blank"
                 rel="noopener noreferrer"
              >
                在百度上查看结果
              </a>
            </a-select-option>
          </template>
          <a-input :style="searchStyle">
            <a-icon slot="suffix" type="search" class="certain-category-icon"/>
          </a-input>
        </a-auto-complete>


        <a-dropdown>
          <div class="ant-dropdown-link mirror-avatar">
            <a-avatar
              class="mirror-pic"
              :size="avatarSize"
              :src="(this.token!==null)?this.curUser.avatar:this.$store.state.defalutAvatar"/>
            <!--下拉信息框-->
            <div class="avatar-dropdown">
              <div v-if="this.token!==null">
                <h3 class="avatar-dropdown-name">{{this.curUser.name}}</h3>
                <div><span class="userInfoName">邮箱:</span>{{this.curUser.email}}</div>
                <!--<div><span class="userInfoName">手机:</span>{{this.curUser.phone}}</div>-->
                <div><span class="userInfoName">性别:</span><span v-text="this.curUser.sex?'男':'女'"></span></div>
                <div><span class="userInfoName">注册时间:</span>{{this.curUser.registerTime|dateFmt}}</div>
                <!--<div>最后更新:{{this.curUser.lastUpdateTime}}</div>-->
                <!--<div>积分:{{this.curUser.score}}</div>-->
                <div>
                  <a-button type="primary" @click="CLogOut">注销</a-button>
                </div>
              </div>

              <div v-if="this.token===null">
                <div style="margin-top: 36px">
                  <img :src="this.$store.state.defalutSmallGifAvatar"/>
                </div>
                <div style="padding: 36px">
                  <div style="margin-bottom: 15px">
                    <span>还没有登录嗷~</span>
                  </div>
                  <a-button style="float: left;" @click="CLoginModal">登录</a-button>
                  <a-button style="float: right;" @click="CRegisterModal">注册</a-button>
                </div>
              </div>
            </div>
          </div>
        </a-dropdown>
      </a-menu>
    </div>
    <!--上抽屉-->
    <top-drawer/>
    <!--左抽屉-->
    <left-drawer/>
    <!--右抽屉-->
    <right-drawer/>
    <!--登录-->
    <login/>
    <!--注册-->
    <register/>

  </div>
</template>
<script>


  import {mapMutations, mapState} from 'vuex'
  import VueQArt from 'vue-qart'
  import LeftDrawer from '@/common/drawer/LeftDrawer'
  import RightDrawer from '@/common/drawer/RightDrawer'
  import TopDrawer from '@/common/drawer/TopDrawer'
  //登录页
  import Login from '@/common/user/Login'
  import Register from '@/common/user/Register'

  export default {
    name: 'NavBar',
    components: {
      VueQArt,
      LeftDrawer,
      RightDrawer,
      Login,
      Register,
      TopDrawer
    },
    computed: {
      ...mapState(['mirrorTheme', 'loginModel', 'curUser', 'token'])
    },
    data() {
      return {
        //头像下拉框
        avatarDropdown: false,
        //抽屉
        avatarSize: 40,
        //搜索框
        searchStyle: 'width:150px',
        searchInput: null,
        searchDataSource: [],
        //二维码
        config: {
          value: window.location.href,
          imagePath: this.$store.state.codeImagePath,
          filter: "color"
        },
        allCategory: [],
        dropdownState: false,
      }
    },
    mounted() {
      this.getAllCategory()
    },
    methods: {
      ...mapMutations([
        'changeLeftDrawer', 'changeRightDrawer', 'changeTopDrawer',
        'changeLoginModal', 'changeRegisterModal',
        'userLogin', 'userToken', 'userLogOut',
      ]),
      CTopDrawer() {
        this.changeTopDrawer(true)
      },
      CLeftDrawer() {
        this.changeLeftDrawer(true)
      },
      CRightDrawer() {
        this.changeRightDrawer(true)
      },
      CLoginModal() {
        this.changeLoginModal(true)
      },
      CRegisterModal() {
        this.changeRegisterModal(true)
      },
      CLogOut() {
        this.userLogin(null)
        this.userToken(null)
        this.userLogOut()
      },

      searchFocus() {
        this.searchStyle = 'width:426px'

      },
      searchBlur() {
        this.searchStyle = 'width:150px'
        this.dropdownState = false
      },
      getAllCategory() {
        this.$http.get('/category/all').then(res => {
          this.allCategory = res.data.data
        })
      },
      toCategory(id) {
        this.$router.push({path: `/category/${id}`})
      },
      //全文搜索
      loadSearchData() {
        if (this.timeoutflag != null) {
          clearTimeout(this.timeoutflag);
        }
        this.timeoutflag = setTimeout(() => {
          this.loadSearchDataSource();
        }, 800)
      },
      loadSearchDataSource() {
        if (this.searchInput !== null) {
          this.$http.paramsGet('/es/article/search', {
            condition: this.searchInput,
            pageNum: 0,
            pageSize: 5,
          }).then(res => {
            if (res.data.result !== 'ok') {
              this.$message.info('没有搜索结果')
            }
            let data = res.data.data
            if (data.content !== null) {
              this.searchDataSource = data
              this.dropdownState = true
            } else {
              this.$message.info('没有搜索结果')
            }
          })
        }
      },
      view(id) {
        this.$router.push({path: `/view/${id}`})
      },
    }
  }
</script>
<style scoped>
  .navbar {
    box-shadow: 0 0.5rem 1rem rgba(102, 102, 102, 0.1) !important;
  }

  #mirrorming {
    font-style: italic;
    font-size: 18px;
    font-weight: 500;

  }

  .mirror-btn {
    float: right;
    margin: 10px;
  }

  .mirror-search {
    margin: 10px;
    float: right;
    cursor: pointer;
    transition: all 0.6s;
  }

  .mirror-pic {
    z-index: 2;
    float: right;
    margin: 5px;
    transition: all 0.5s;
  }

  .mirror-pic:hover {
    transform: translate(-15px, 26px) scale(1.6);
  }

  .mirror-avatar:hover .mirror-pic {
    transform: translate(-15px, 26px) scale(1.6);
  }

  .mirror-avatar {
    margin-right: 22px;
    float: right;
    position: relative;
  }

  .mirror-avatar:hover .avatar-dropdown {
    height: 300px;
    max-height: 301px;
    opacity: 1;
    transform: translate3d(0, 0, 0);
  }

  .avatar-dropdown {
    opacity: 0;
    z-index: 1;
    position: absolute;
    background-color: rgba(255, 255, 255, 0.98);
    top: 54px;
    left: -120px;
    height: 0px;
    width: 260px;
    box-shadow: 0 0.5rem 1rem rgba(102, 102, 102, 0.1);
    overflow: hidden;
    text-align: center;
    transition: ease-in-out 0.5s;
    transform: translate3d(0, -20%, 0);
  }

  .avatar-dropdown-name {
    margin-top: 20px;
  }

  .userInfoName {
    font-weight: 600;
  }

  .iconfont {
    font-size: 15px;
    color: #45494c;
    margin-right: 5px;
  }
</style>
<style>
  .searchSelectOpt {
    max-width: 300px;
  }

  .mirror-search-dropdown {
    width: 426px;
  }

  .selectItem strong {
    color: #ff5656;
  }
</style>
