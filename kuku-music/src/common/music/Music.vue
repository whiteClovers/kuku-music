<template>
  <!--
    指定 lrcType 为 1，表示 audio.lrc 的值是 lrc 字符串
    指定 lrcType 为 3，表示 audio.lrc 的值是 lrc 文件地址，将通过 `fetch` 获取 lrc 歌词文本
    指定 lrcType 为 0，表示禁用歌词
  -->
  <aplayer
    :audio="audio"
    :volume.sync="volume"
    :lrcType="1"
    @update:volume="updateVolume"
    @onListSwitch="onListSwitch"
    @onEnded="onEnded"
    @onPause="onPause"
    @onPlaying="onPlaying"
    @lrcShow="lrcShow"
    @lrcHide="lrcHide"
    fixed
  />
</template>

<script>
  import APlayer from '@moefe/vue-aplayer';

  export default {
    name: 'Music',
    components: {
      APlayer
    },
    data() {
      return {
        audio: [],
        volume: 0.7,
        timeoutflag: null,
      };
    },
    mounted() {
      this.getMusicList()
    },
    methods: {
      getMusicList() {
        this.$http.get('/music/list').then(res => {
          // 执行某些操作
          this.audio = res.data.data
          // console.log(this.audio)
        })
      },
      // @canplay="canplay"
      canplay() {
        this.$message.info('音乐缓冲完成')
      },
      // @emptied="emptied"
      emptied() {
        this.$message.info('连接意外断开')
      },
      updateVolume() {
        if (this.timeoutflag != null) {
          clearTimeout(this.timeoutflag);
        }
        this.timeoutflag = setTimeout(() => {
          this.$message.info('播放器音量修改为 ' + Number(this.volume * 100).toFixed(0) + ' %')
        }, 800)
      },
      onListSwitch() {
        this.$message.info('切换歌曲')
      },


      onEnded() {
        this.$message.info('播放完成')
      },
      onPlaying() {
        this.$message.info('正在播放xx')
      },
      onPause() {
        this.$message.info('音乐暂停')
      },
      lrcShow() {
        this.$message.info('歌词打开')
      },
      lrcHide() {
        this.$message.info('歌词关闭')
      }
    }
  };
</script>
