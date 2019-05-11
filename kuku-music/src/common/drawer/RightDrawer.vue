<template>
  <div>
    <a-drawer
      title="mirror-blog"
      placement="right"
      :closable="true"
      @close="CRightDrawer"
      :visible="this.rightDrawer"
    >
      <div>
        <a-divider>导航栏主题修改</a-divider>
        <a-select labelInValue :defaultValue="{key:this.mirrorTheme}" @change="CTheme" style="width: 100%">
          <a-select-option value="light">亮色</a-select-option>
          <a-select-option value="dark">暗色</a-select-option>
        </a-select>

        <a-divider>背景图片</a-divider>
        <a-select labelInValue :defaultValue="{key:this.$store.state.bg}" @change="CBg" style="width: 100%">
          <a-select-option value="white">纯白</a-select-option>
          <a-select-option value="bing">使用Bing壁纸</a-select-option>
          <a-select-option value="disabled" disabled>待添加...</a-select-option>
        </a-select>
        <div v-if="this.$store.state.bg!=='white'">
          <a-divider>遮罩透明度</a-divider>
          <a-slider
            :min="0" :max="1" :step="0.1"
            :defaultValue="parseInt(this.$store.state.maskOpacity)"
            @change="CMaskOpacity"
          />
        </div>

        <!--<a-divider>修改文章列表动画</a-divider>-->
        <!--<a-select labelInValue :defaultValue="{key:this.$store.state.leftAnimate}" @change="CLeftAnimate"-->
        <!--style="width: 100%">-->
        <!--<a-select-option v-for="(item,index) in enterArr" :key="item" :value="item">{{item}}</a-select-option>-->
        <!--</a-select>-->

        <!--<a-divider>修改右侧区域动画</a-divider>-->
        <!--<a-select labelInValue :defaultValue="{key:this.$store.state.rightAnimate}" @change="CRightAnimate"-->
        <!--style="width: 100%">-->
        <!--<a-select-option v-for="(item,index) in enterArr" :key="item" :value="item">{{item}}</a-select-option>-->
        <!--</a-select>-->

        <a-divider>修改导航栏动画</a-divider>
        <a-select labelInValue :defaultValue="{key:this.$store.state.navbarAnimate}" @change="CTopAnimate"
                  style="width: 100%">
          <a-select-option v-for="(item,index) in enterArr" :key="item" :value="item">{{item}}</a-select-option>
        </a-select>

        <a-divider>页面进入动画</a-divider>
        <a-select labelInValue :defaultValue="{key:this.$store.state.navEnterAnimate}" @change="CNavEnterAnimate"
                  style="width: 100%">
          <a-select-option v-for="(item,index) in enterArr" :key="item" :value="item">{{item}}</a-select-option>
        </a-select>

        <a-divider>页面离开动画</a-divider>
        <a-select labelInValue :defaultValue="{key:this.$store.state.navLeaveAnimate}" @change="CNavLeaveAnimate"
                  style="width: 100%">
          <a-select-option v-for="(item,index) in leaveArr" :key="item" :value="item">{{item}}</a-select-option>
        </a-select>
        <a-divider>更改动画速度</a-divider>
        <a-select labelInValue :defaultValue="{key:this.$store.state.animateSpeed}" @change="CAnimateSpeed"
                  style="width: 100%">
          <a-select-option key="faster" value="faster">500ms</a-select-option>
          <a-select-option key="fast" value="fast">800ms</a-select-option>
          <a-select-option key="default" value="">1s</a-select-option>
          <a-select-option key="slow" value="slow">2s</a-select-option>
          <a-select-option key="slower" value="slower">3s</a-select-option>
        </a-select>
      </div>

    </a-drawer>
  </div>
</template>
<script>
  import {mapMutations, mapState} from 'vuex';

  export default {
    name: 'RightDrawer',
    components: {},
    data() {
      return {
        theme: this.mirrorTheme,
        enterArr: [],
        leaveArr: [],
      }
    },
    beforeMount() {
      this.enterArr = this.animateEnterArr
      this.leaveArr = this.animateLeaveArr
    },
    computed: {
      ...mapState([
        'rightDrawer',
        'mirrorTheme',
        'topAnimate',
        'leftAnimate', 'rightAnimate',
        'navEnterAnimate', 'navLeaveAnimate',
        'animateEnterArr', 'animateLeaveArr',
      ])
    },
    methods: {
      ...mapMutations([
        'changeTheme',
        'changeBg',
        'changeMaskColor', 'changeMaskOpacity',
        'changeRightDrawer',
        // 'changeArticleListAnimate', 'changeRightAnimate',
        'changeNavBarAnimate', 'changeNavEnterAnimate', 'changeNavLeaveAnimate', 'changeAnimateSpeed'
      ]),
      CRightDrawer() {
        this.changeRightDrawer(false)
      },
      CTheme(val) {
        let navbarTheme = val.key
        this.changeTheme(navbarTheme)
      },
      CBg(val) {
        let _bg = val.key
        this.changeBg(_bg)
      },
      CMaskOpacity(val) {
        console.log(this.$store.state.maskOpacity)
        let _maskOpacity = val
        this.changeMaskOpacity(_maskOpacity)
      },
      //改变进出动画
      CNavEnterAnimate(val) {
        let _navEnterAnimate = val.key
        this.changeNavEnterAnimate(_navEnterAnimate)
      },
      CNavLeaveAnimate(val) {
        let _navLeaveAnimate = val.key
        this.changeNavLeaveAnimate(_navLeaveAnimate)
      },
      //改变navbar进入动画
      CTopAnimate(val) {
        let _topAnimate = val.key
        this.changeNavBarAnimate(_topAnimate)
      },
      // CLeftAnimate(val) {
      //   let _leftAnimate = val.key
      //   this.changeArticleListAnimate(_leftAnimate)
      // },
      // CRightAnimate(val) {
      //   let _rightAnimate = val.key
      //   this.changeRightAnimate(_rightAnimate)
      // },
      //动画速度
      CAnimateSpeed(val) {
        let _animateSpeed = val.key
        this.changeAnimateSpeed(_animateSpeed)
      }
    }
  }
</script>
<style scoped>

</style>
