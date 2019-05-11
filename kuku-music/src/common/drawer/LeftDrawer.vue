<template>
  <div class="left-drawer">
    <a-drawer
      title="mirrorming"
      placement="left"
      :closable="true"
      :visible="this.leftDrawer"
      @close="this.CLeftDrawer"
    >
      <div>
        <a-divider>联系我</a-divider>
        <ul class="mirrorContact">
          <li>
            <a-popover title="GitHub" trigger="hover" placement="bottomLeft">
              <template slot="content">
                <p><img src="https://i.loli.net/2019/02/19/5c6bb1b36affa.png"/></p>
              </template>
              <a href="https://github.com/mirrormingzZ/">
                <span class="iconfont">&#xe81b;</span>
              </a>
            </a-popover>
          </li>
          <li>
            <a-popover title="Bilibili" trigger="hover" placement="bottom">
              <template slot="content">
                <p><img src="https://i.loli.net/2019/02/19/5c6bb2c19d3d5.png"/></p>
              </template>
              <a href="https://space.bilibili.com/53371355/">
                <span class="iconfont">&#xe6f8;</span>
              </a></a-popover>
          </li>

          <li>
            <a-popover title="QQ" trigger="hover" placement="bottomRight">
              <template slot="content">
                <p>点击可以直接聊天</p>
                <p><img src="https://i.loli.net/2019/02/19/5c6bb5ec71990.jpg"/></p>
              </template>
              <a href="tencent://message/?uin=1060996414&Site=QQ交谈&Menu=yes">
                <span class="iconfont">&#xe81a;</span>
              </a>
            </a-popover>
          </li>
          <li>
            <a-popover title="微信" trigger="hover" placement="bottomLeft">
              <template slot="content">
                <p style="font-weight: 600">我的微信</p>
                <p><img src="https://i.loli.net/2019/02/19/5c6bb1b3d0609.png"/></p>
                <p style="font-weight: 600">我的公众号</p>
                <p><img src="https://i.loli.net/2019/02/19/5c6bb1b414dbb.jpg"/></p>
              </template>
              <span class="iconfont">&#xe688;</span>
            </a-popover>
          </li>
          <li>
            <a-popover title="Twitter" trigger="hover" placement="bottom">
              <template slot="content">
                <p><img src="https://i.loli.net/2019/02/19/5c6bb1b3a33e3.png"/></p>
              </template>
              <a href="https://mobile.twitter.com/1060996414Com">
                <span class="iconfont">&#xe68a;</span>
              </a></a-popover>
          </li>
          <li>
            <a-popover title="微博" trigger="hover" placement="bottomRight">
              <template slot="content">
                <p><img src="https://i.loli.net/2019/02/19/5c6bb1b3b152a.png"/></p>
              </template>
              <a href="https://weibo.com/mirrormingzZ">
                <span class="iconfont">&#xe671;</span>
              </a>
            </a-popover>
          </li>

          <li>
            <a-popover title="邮件" trigger="hover">
              <template slot="content">
                <p>点我发送邮件</p>
              </template>
              <a href="http://mail.qq.com/cgi-bin/qm_share?t=qm_mailme&email=hejs9-fq9_js6_LF9PSr5uro">
                <span class="iconfont">&#xe81a;</span>
              </a>
            </a-popover>
          </li>
        </ul>


      </div>
      <div class="weather">
        <a-divider>天气</a-divider>
        <iframe
          src="//www.seniverse.com/weather/weather.aspx?uid=UD9E6B0A35&cid=CHBJ000000&l=zh-CHS&p=SMART&a=1&u=C&s=5&m=2&x=1&d=3&fc=&bgc=&bc=C6C6C6&ti=0&in=1&li="
          frameborder="0" scrolling="no" width="200" height="300" allowTransparency="true"></iframe>
      </div>
    </a-drawer>
  </div>
</template>
<script>
  import {mapMutations, mapState} from 'vuex';



  export default {
    name: 'LeftDrawer',
    components: {
    },
    data() {
      return {}
    },
    computed: {
      ...mapState(['leftDrawer'])
    },
    methods: {
      ...mapMutations(['changeLeftDrawer']),
      CLeftDrawer() {
        this.changeLeftDrawer(false)
      },
    }
  }
</script>
<style scoped>
  .mirrorContact li {
    display: inline-block;
    padding: 16px 8px 16px 8px;
    list-style-type: none;
  }
  .mirrorContact li span{
    font-size: 32px;
  }

  .mirrorContact li a {
    text-decoration: none;
    color: rgba(0, 0, 0, 0.51);
  }

  img {
    width: 200px;
  }

</style>
