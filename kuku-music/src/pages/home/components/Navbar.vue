<template>
  <Menu mode="horizontal" :theme="theme" active-name="1">

    <Row>
      <Col span="16" offset="4">
        <MenuItem name="1">
          <h1> Kuku </h1>
        </MenuItem>
        <MenuItem name="2">
          <Icon type="ios-people"/>
          <router-link tag="span" to="/">
            首页
          </router-link>
        </MenuItem>

        <!--<Submenu name="3">-->
        <!--<template slot="title">-->
        <!--<Icon type="ios-stats"/>-->
        <!--统计分析-->
        <!--</template>-->
        <!--<MenuGroup title="使用">-->
        <!--<MenuItem name="3-1">新增和启动</MenuItem>-->
        <!--<MenuItem name="3-2">活跃分析</MenuItem>-->
        <!--<MenuItem name="3-3">时段分析</MenuItem>-->
        <!--</MenuGroup>-->
        <!--<MenuGroup title="留存">-->
        <!--<MenuItem name="3-4">用户留存</MenuItem>-->
        <!--<MenuItem name="3-5">流失用户</MenuItem>-->
        <!--</MenuGroup>-->
        <!--</Submenu>-->
        <MenuItem name="3">
          <Icon type="ios-construct"/>
          <router-link tag="span" to="/musicSearch">
            音乐搜索
          </router-link>
        </MenuItem>
        <MenuItem name="4">
          <Icon type="ios-construct"/>
          <router-link tag="span" to="/">
            我的音乐
          </router-link>
        </MenuItem>


        <!--right-->
        <MenuItem name="9" class="floatRight">
          <Poptip trigger="hover" placement="bottom-end">
            <span name="1">
              主题切换
            </span>
            <div class="api" slot="content">
              <RadioGroup v-model="theme" class="themeFontColor">
                <Radio label="light">亮色</Radio>
                <Radio label="dark">暗色</Radio>
                <Radio label="primary">蓝色</Radio>
              </RadioGroup>
            </div>
          </Poptip>
        </MenuItem>

        <!--user-->
        <Dropdown class="floatRight">
          <span>
            <Avatar size="large"
                    :src="this.$store.state.curUser==null?'https://i.loli.net/2017/08/21/599a521472424.jpg':this.curloginUser.pic"/>
          </span>
          <DropdownMenu slot="list">
            <div v-if="loginState">
              <DropdownItem>
                <Button @click="loginModal = true">登录</Button>
              </DropdownItem>
              <DropdownItem>
                <Button @click="loginModal = true">注册</Button>
              </DropdownItem>
            </div>
            <div v-if="loginState">
              <DropdownItem> <span  @click="toMySet">个人设置</span></DropdownItem>
              <DropdownItem><span  @click="toMusicList">我的歌单</span></DropdownItem>
              <DropdownItem>？？</DropdownItem>
            </div>
          </DropdownMenu>
        </Dropdown>


        <Modal
          v-model="loginModal"
          :footer-hide="true"
          class-name="vertical-center-modal">
          <p slot="header" style="text-align:center">
            <Avatar icon="ios-person" size="small"/>
            <span>用户登录</span>
          </p>
          <div style="">
            <Form ref="formInline" :model="formInline" :rules="ruleInline">
              <FormItem prop="user" style="padding: 10px">
                <Input type="text" v-model="formInline.user" placeholder="手机号">
                  <Icon type="ios-person-outline" slot="prepend"></Icon>
                </Input>
              </FormItem>
              <FormItem prop="password" style="padding: 10px">
                <Input type="password" v-model="formInline.password" placeholder="密码">
                  <Icon type="ios-lock-outline" slot="prepend"></Icon>
                </Input>
              </FormItem>
              <FormItem style="float: right">
                <Button type="primary" @click="handleSubmit('formInline')">登录</Button>
              </FormItem>
            </Form>
          </div>
        </Modal>


        <!--search-->
        <!--<AutoComplete-->
        <!--v-model="searchValue"-->
        <!--icon="ios-search"-->
        <!--placeholder="input here"-->
        <!--style="width:200px"-->
        <!--&gt;-->
        <!---->
        <!--<a href="https://www.google.com/search?q=iView" target="_blank" class="demo-auto-complete-more">查看所有结果</a>-->
        <!--</AutoComplete>-->
      </Col>
    </Row>


  </Menu>

</template>
<script>
  import {mapMutations} from 'vuex';

  export default {
    data() {
      return {
        theme: 'light',
        searchValue: null,
        loginState: true,
        curloginUser: {},
        loginModal: false,
        formInline: {
          user: '',
          password: ''
        },
        ruleInline: {
          user: [
            {required: true, message: '请填写用户名', trigger: 'blur'}
          ],
          password: [
            {required: true, message: '请填写密码', trigger: 'blur'},
            {type: 'string', min: 6, message: '密码长度不能小于6位', trigger: 'blur'}
          ]
        },

      }
    },
    methods: {
      ...mapMutations([
        'changeLoginModal',
        'userLogin', 'userToken'
      ]),
      handleSubmit(name) {
        this.$refs[name].validate((valid) => {
          if (valid) {
            this.$Message.success('表单校验通过，登录中...');
            this.login(this.formInline.user, this.formInline.password)
          } else {
            this.$Message.error('表单校验失败!');
          }
        })
      },
      login(phone, pwd) {
        this.$http.post('/login', {
          phone: phone,
          pwd: pwd,
        }).then(res => {
          let data = res.data
          console.log(data)
          this.curloginUser = data.data
          if (data.result === 'ok') {
            this.loginModal = false;
            this.userLogin(this.curloginUser)
            this.loginAvatar = this.curloginUser.pic
            this.loginState = true
            this.$Notice.success({
              title: this.curloginUser.name,
              desc: '登录成功!',
            });
          }
        }).catch((error) => {
          this.$Notice.error({
            message: '很抱歉',
            desc: '登录失败,请检查用户名和密码!',
          })
        })
      },
      toMySet(){
        this.$router.push({path: `/user/${this.curloginUser.userId}`})
      },
      toMusicList(){
        this.$router.push({path: '/musicList'})
      },
    }
  }
</script>
<style scoped>
  .floatRight {
    float: right;
  }

  .themeFontColor > label {
    color: black;
  }
</style>
