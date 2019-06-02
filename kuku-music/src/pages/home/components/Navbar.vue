<template>
  <Menu mode="horizontal" :theme="theme" active-name="1">

    <Row>
      <Col span="16" offset="4">
        <MenuItem name="1">
          <router-link tag="span" to="/">
          <h1> Kuku </h1>
          </router-link>
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
        <MenuItem name="4" v-if="this.$store.state.curUser!=null">
          <Icon type="ios-construct"/>
          <router-link tag="span" to="/MusicList">
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
                    :src="this.$store.state.curUser == null?'https://i.loli.net/2017/08/21/599a521472424.jpg':this.$store.state.curUser.pic"/>
          </span>
          <DropdownMenu slot="list">
            <div v-if="this.$store.state.curUser==null">
              <DropdownItem>
                <Button @click="loginModal = true">登录</Button>
              </DropdownItem>
              <DropdownItem>
                <Button @click="registerModel = true">注册</Button>
              </DropdownItem>
            </div>
            <div v-if="this.$store.state.curUser!=null">
              <DropdownItem>
                <div @click="toMusicList">我的主页</div>
              </DropdownItem>
              <DropdownItem>
                <div @click="toMySet">个人设置</div>
              </DropdownItem>
              <DropdownItem>
                <div @click="validateUser">注销</div>
              </DropdownItem>
            </div>

          </DropdownMenu>
        </Dropdown>


        <Modal
          v-model="loginModal"
          :footer-hide="true"
          class-name="vertical-center-modal"

        >
          <p slot="header" style="text-align:center">
            <Avatar icon="ios-person" size="small"/>
            <span>登录</span>
          </p>
          <div style="height: 185px">
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
                <Button type="primary" @click="handleLoginSubmit('formInline')">登录</Button>
              </FormItem>
            </Form>
          </div>
        </Modal>

        <Modal
          v-model="registerModel"
          :footer-hide="true"
          class-name="vertical-center-modal">
          <p slot="header" style="text-align:center">
            <Avatar icon="ios-person" size="small"/>
            <span>注册</span>
          </p>
          <div style="height: 185px">
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
                <Button type="primary" @click="handleRegisterSubmit('formInline')">注册</Button>
              </FormItem>
            </Form>
          </div>
        </Modal>


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
        registerModel: false,
        formInline: {
          user: '',
          password: ''
        },
        ruleInline: {
          user: [
            // {required: true, message: '请填写手机号', trigger: 'blur'},
            {min: 11, max: 11, message: '手机号长度为11位', trigger: ''}
          ],
          password: [
            // {required: true, message: '请填写密码', trigger: 'blur'},
            {type: 'string', min: 6, message: '密码长度不能小于6位', trigger: 'blur'}
          ]
        },

      }
    },
    methods: {
      ...mapMutations([
        'userLoginFlag',
        'userLogin',
        'userLogOut'
      ]),

      /* 用户注册 */
      handleRegisterSubmit(name) {
        this.$Message.success('正在注册...');
        this.register(this.formInline.user, this.formInline.password)
      },
      register: function (phone, pwd) {
        this.$http.post('/register', {
          phone: phone,
          pwd: pwd,
        }).then(res => {
          let data = res.data
          console.log(data)
          this.registerModel = false;
          this.$Notice.success({
            title: this.curloginUser.name,
            desc: '注册成功!'
          })
        }).catch((error) => {
          this.$Notice.error({
            message: '很抱歉',
            desc: '注册失败,请检查用户名和密码是否符合要求!',
          })
        })
      },

      /* 用户登录 */
      handleLoginSubmit(name) {
        this.$Message.success('登录中...');
        this.login(this.formInline.user, this.formInline.password)
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
            this.registerModel = false;
            this.loginState = false
            this.userLogin(this.curloginUser, null, this.loginState);
            this.loginAvatar = this.curloginUser.pic
            this.userLoginFlag(true)

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

      /* 注销 */
      validateUser() {
        this.$http.get('/validate').then(res => {
          // 执行某些操作
          this.userLogOut();
          this.loginState = false
          console.log(this.$store.state.curUser)
          this.userLoginFlag(false)
          this.$router.push({path: '/'})
        })

      },

      /* 路由跳转 */
      toMySet() {
        this.$router.push({path: `/user/${this.$store.state.curUser.userId}`})
      },
      toMusicList() {
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
