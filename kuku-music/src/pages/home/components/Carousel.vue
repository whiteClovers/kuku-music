<template>
  <Row justify="center" align="middle" style="margin-top: 25px">
    <Col span="16" offset="4">
      <Carousel v-model="value1" loop style="height: 400px;overflow: hidden">
        <CarouselItem>
          <div class="demo-carousel">
            <img style="width: 100%"
              src="http://p2.music.126.net/p-7pKS_S86OJo8cHcDNKFw==/109951163922821064.jpg"/>
          </div>
        </CarouselItem>
        <CarouselItem>
          <div class="demo-carousel">
            <img style="width: 100%"
              src="http://p1.music.126.net/VGosFy3yK__PC9YRolQKiA==/109951164067466354.jpg"/>
          </div>
        </CarouselItem>
        <CarouselItem>
          <div class="demo-carousel">
            <img style="width: 100%"
              src="http://p1.music.126.net/SMcO8l89IcUbeR126ujJSQ==/109951164063413801.jpg"/>
          </div>
        </CarouselItem>
        <CarouselItem>
          <div class="demo-carousel">
            <img style="width: 100%"
              src="http://p1.music.126.net/dQ2VmwPROMrTPaYjYithOw==/109951164067468986.jpg"/>
          </div>
        </CarouselItem>

      </Carousel>
    </Col>
  </Row>

</template>
<script>
  export default {
    data() {
      return {
        value1: 0
      }
    }
  }
</script>
