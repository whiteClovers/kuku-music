<template>
  <Row justify="center" align="middle" style="margin-top: 25px">
      <div class="musicList">
        <div>
          <Card style="width:366px;float: left;margin: 20px" v-for="item in listData" :key="item.musicId">
            <div style="text-align:center">
              <img style="height: 320px;width: 280px" :src="item.cover">
              <p slot="title">歌曲名：{{item.name}} </p>
              <p slot="title">歌手名：{{item.artist}} </p>
              <!--<p :description="item.album.name"></p>-->

            </div>
          </Card>

        </div>

      </div>

  </Row>


</template>
<script>

  export default {
    name: 'CloudMusic',
    components: {},
    data() {
      return {
        // 热门歌曲
        listData: [],



      }
    },
    methods: {
      loadHostMusic() {
        this.$http.get('/music/hotMusic').then(res => {
          console.log("hotmusic: " + res.data)
          this.listData = res.data
        }).catch((error) => {
          this.$Notice.error({
          message: '很抱歉',
          desc: '加载失败!',
        })
        })
      },
    },
    mounted() {
      this.loadHostMusic()
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
</style>
