<template>
  <div class="left-drawer">
    <a-drawer
      title="常用工具网站"
      placement="top"
      :closable="true"
      :visible="this.topDrawer"
      @close="this.CTopDrawer"
    >
      <div>
        <a-tabs defaultActiveKey="1" tabPosition="top">
          <a-tab-pane tab="在线编辑" key="1">
            <a-button>
              <a href="https://smallpdf.com/cn/pdf-to-word" target="_blank"> PDF 转换器 </a>
            </a-button>
            <a-button>
              <a href="https://www.bejson.com/jsoneditoronline" target="_blank"> JSON 编辑器 </a>
            </a-button>
            <a-button>
              <a href="https://tool.lu/tables/" target="_blank"> MD 表格生成 </a>
            </a-button>
            <a-button>
              <a href="http://cron.qqe2.com/" target="_blank"> CRON 表达式 </a>
            </a-button>
            <a-button>
              <a href="http://tool.oschina.net/codeformat/html" target="_blank"> 代码格式化 </a>
            </a-button>
            <a-button>
              <a href="https://zh.numberempire.com/latexequationeditor.php" target="_blank"> 公式编辑器 </a>
            </a-button>
            <a-button>
              <a href="https://cli.im/" target="_blank"> 二维码生成器 </a>
            </a-button>
            <a-button>
              <a href="http://tool.chinaz.com/tools/native_ascii.aspx" target="_blank"> 在线编码转换 </a>
            </a-button>
            <a-button>
              <a href="http://www.toyaml.com" target="_blank"> YAML &lt;-&gt; Properties </a>
            </a-button>
            <a-button>
              <a href="https://jsfiddle.net/" target="_blank"> 在线 Web 练习 </a>
            </a-button>
          </a-tab-pane>
          <a-tab-pane tab="在线服务" key="2">
            <a-button>
              <a href="https://www.bootcdn.cn/" target="_blank"> Boot CDN </a>
            </a-button>
            <a-button>
              <a href="http://cdn.code.baidu.com/" target="_blank"> 百度 CDN </a>
            </a-button>
            <a-button>
              <a href="http://qydev.weixin.qq.com/cdn/cdnjs.html" target="_blank"> 微信 CDN </a>
            </a-button>
            <a-button>
              <a href="https://servers.ustclug.org/2014/06/blog-googlefonts-speedup/" target="_blank"> 科大谷歌字体加速 </a>
            </a-button>
            <a-button>
              <a href="https://tldr.ostera.io/" target="_blank"> tldr 命令手册 </a>
            </a-button>
          </a-tab-pane>
          <a-tab-pane tab="开源镜像" key="3">
            <a-button>
              <a href="https://opsx.alibaba.com/" target="_blank"> OPSX </a>
            </a-button>
            <a-button>
              <a href="https://mirror.azure.cn/" target="_blank"> AZURE </a>
            </a-button>
            <a-button>
              <a href="https://hub.docker.com/" target="_blank"> Docker HUB </a>
            </a-button>
          </a-tab-pane>
          <a-tab-pane tab="趋势分析" key="4">
            <a-button>
              <a href="https://trends.google.com/trends/?geo=US" target="_blank"> 谷歌趋势 </a>
            </a-button>
            <a-button>
              <a href="http://index.baidu.com/#/" target="_blank"> 百度指数 </a>
            </a-button>
            <a-button>
              <a href="https://tongji.baidu.com/data/browser" target="_blank"> 百度流量研究院 </a>
            </a-button>
          </a-tab-pane>
          <a-tab-pane tab="很强的工具" key="5">
            <a-button>
              <a href="https://uzer.me" target="_blank"> 云端超级应用空间 </a>
            </a-button>
            <a-button>
              <a href="https://www.yasuotu.com/size" target="_blank"> 在线图片处理 </a>
            </a-button>
            <a-button>
              <a href="https://www.tianyancha.com/" target="_blank"> 天眼查 </a>
            </a-button>
            <a-button>
              <a href="https://www.sojson.com/image/change.html" target="_blank"> 在线图片处理2 </a>
            </a-button>
            <a-button>
              <a href="https://link.hhtjim.com/" target="_blank"> 外链转换 </a>
            </a-button>
            <a-button>
              <a href="http://asciiflow.com/" target="_blank"> asciiflow </a>
            </a-button>
            <a-button>
              <a href="https://linxz.github.io/tianyizone/" target="_blank"> css小工具集合 </a>
            </a-button>
            <a-button>
              <a href="https://smallpdf.com/cn/pdf-to-word" target="_blank"> PDF转Word转换器 </a>
            </a-button>
            <a-button>
              <a href="https://www.qs5.org/csdn/" target="_blank"> CSDN免积分下载 </a>
            </a-button>
            <a-button>
              <a href="https://www.jijidown.com/" target="_blank"> Bilibili视频下载 </a>
            </a-button>
          </a-tab-pane>
          <a-tab-pane tab="常用" key="6">
            <a-button>
              <a href="https://www.google.com/" target="_blank"> Google </a>
            </a-button>
            <a-button>
              <a href="https://stackoverflow.com/" target="_blank"> StackOverFlow </a>
            </a-button>
            <a-button>
              <a href="https://leetcode-cn.com/problemset/all/" target="_blank"> LeetCode </a>
            </a-button>
            <a-button>
              <a href="https://www.nowcoder.com/" target="_blank"> 牛客网 </a>
            </a-button>
            <a-button>
              <a href="https://segmentfault.com/" target="_blank"> Segmentfault </a>
            </a-button>
            <a-button>
              <a href="http://www.chuangzaoshi.com/code" target="_blank"> 创造狮导航 </a>
            </a-button>
            <a-button>
              <a href="http://e.xitu.io/" target="_blank"> 掘金 </a>
            </a-button>
            <a-button>
              <a href="https://www.v2ex.com/" target="_blank"> V2EX </a>
            </a-button>
            <a-button>
              <a href="http://www.chuangzaoshi.com/code" target="_blank"> 创造狮导航 </a>
            </a-button>
          </a-tab-pane>
          <a-tab-pane tab="关于我" key="7">
            <a-button>
              <a href="https://mirrormingzz.github.io/" target="_blank"> 我的GitHub博客 </a>
            </a-button>
            <a-button>
              <a href="https://github.com/mirrormingzZ/" target="_blank"> 我的GitHub </a>
            </a-button>
            <a-button>
              <a href="https://space.bilibili.com/53371355" target="_blank"> 我的哔哩哔哩 </a>
            </a-button>
            <a-button>
              <a href="mirrorming.cn:4396" target="_blank"> 旧版博客 </a>
            </a-button>
          </a-tab-pane>
        </a-tabs>
      </div>


    </a-drawer>
  </div>


</template>
<script>
  import {mapMutations, mapState} from 'vuex';

  export default {
    name: 'TopDrawer',
    components: {},
    data() {
      return {}
    },
    computed: {
      ...mapState(['topDrawer'])
    },
    methods: {
      ...mapMutations(['changeTopDrawer']),
      CTopDrawer() {
        this.changeTopDrawer(false)
      },

    }
  }
</script>
<style scoped>
  button {
    margin: 15px;
  }
</style>
