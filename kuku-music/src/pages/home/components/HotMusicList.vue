<template>
  <Row justify="center" align="middle">
    <Col span="16" offset="4">
      <div style="padding: 15px">
        <Card style="float: left;margin: 15px" v-for="item in 12" :key="item" :padding="16">
          <div style="text-align:center">
            <img src="https://p2.music.126.net/aVnOtCgXsOzqGFUqjSCgww==/109951163991664147.jpg?param=140y140">
            <h4>A high quality </h4>
          </div>
        </Card>
      </div>
    </Col>
  </Row>
</template>
<script>
  export default {
    name: 'HotMusic',
  }
</script>
<style scoped>

</style>
   
