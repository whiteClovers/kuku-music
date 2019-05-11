<template>
  <!--
    指定 lrcType 为 1，表示 audio.lrc 的值是 lrc 字符串
    指定 lrcType 为 3，表示 audio.lrc 的值是 lrc 文件地址，将通过 `fetch` 获取 lrc 歌词文本
    指定 lrcType 为 0，表示禁用歌词
  -->
  <div>
    <Row justify="center" align="middle" style="margin-top: 25px">
      <Col span="16" offset="4">
        <aplayer
          :audio="audio"
          :volume.sync="volume"
          :lrcType="3"
          @update:volume="updateVolume"
          @onListSwitch="onListSwitch"
          @onEnded="onEnded"
          @onPause="onPause"
          @onPlaying="onPlaying"
          @lrcShow="lrcShow"
          @lrcHide="lrcHide"

        />
      </Col>
    </Row>
  </div>
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
        audio: [
          {
            name: '东西（Cover：林俊呈）',
            artist: '纳豆',
            url: 'https://cdn.moefe.org/music/mp3/thing.mp3',
            cover: 'https://p1.music.126.net/5zs7IvmLv7KahY3BFzUmrg==/109951163635241613.jpg?param=300y300', // prettier-ignore
            lrc: 'https://cdn.moefe.org/music/lrc/thing.lrc',
          },
          {
            name: '响喜乱舞（Cover：MARiA）',
            artist: '泠鸢yousa',
            url: 'https://cdn.moefe.org/music/mp3/kyoukiranbu.mp3',
            cover: 'https://p1.music.126.net/AUGVPQ_rVrngDH9ocQrn3Q==/109951163613037822.jpg?param=300y300', // prettier-ignore
            lrc: 'https://cdn.moefe.org/music/lrc/kyoukiranbu.lrc',
          },
          {
            name: '啵唧',
            artist: 'Hanser',
            url: 'https://cdn.moefe.org/music/mp3/kiss.mp3',
            cover: 'https://p1.music.126.net/K0-IPcIQ9QFvA0jXTBqoWQ==/109951163636756693.jpg?param=300y300', // prettier-ignore
            lrc: 'https://cdn.moefe.org/music/lrc/kiss.lrc',
          },
        ],
        volume: 0.7,
        timeoutflag: null,
      };
    },
    mounted() {
      // this.getMusicList()
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
        this.$Message.info('音乐缓冲完成')
      },
      // @emptied="emptied"
      emptied() {
        this.$Message.info('连接意外断开')
      },
      updateVolume() {
        if (this.timeoutflag != null) {
          clearTimeout(this.timeoutflag);
        }
        this.timeoutflag = setTimeout(() => {
          this.$Message.info('播放器音量修改为 ' + Number(this.volume * 100).toFixed(0) + ' %')
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
