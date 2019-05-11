<template>
  <div id="components-modal-demo-position">
    <a-modal
      title="登录"
      centered
      :visible="this.$store.state.loginModal"
      @cancel="CLoginModal()"
      :footer="null"
    >
      <a-form :form="form" id='mirror-login' @submit="handleSubmit" class='login-form'>
        <a-form-item>
          <a-input
            size="large"
            placeholder='邮箱'
            v-decorator="['loginCode',{ rules: [{ required: true, message: '请输入邮箱!' }] }]"
          >
            <a-icon slot="prefix" type='user' style="color: rgba(0,0,0,.25)"/>
          </a-input>
        </a-form-item>
        <a-form-item>
          <a-input
            size="large"
            v-decorator="['pwd',{ rules: [{ required: true, message: '请输入密码!' }] }]"
            type='password'
            placeholder='密码'
          >
            <a-icon slot="prefix" type='lock' style="color: rgba(0,0,0,.25)"/>
          </a-input>
        </a-form-item>
        <a-form-item>
          <a-checkbox v-decorator="['remember',{valuePropName: 'checked',initialValue: true,}]">
            记住密码
          </a-checkbox>
          <a class='login-form-forgot' href=''>忘记密码</a>
          <a-button style="width: 100%" type='primary' htmlType='submit' class='login-form-button' :loading='loading'>
            登录
          </a-button>
        </a-form-item>
      </a-form>

    </a-modal>
  </div>
</template>

<script>
  import {mapMutations} from 'vuex';

  export default {
    data() {
      return {
        loading: false,
      }
    },
    beforeCreate() {
      this.form = this.$form.createForm(this);
    },
    methods: {
      ...mapMutations([
        'changeLoginModal',
        'userLogin', 'userToken'
      ]),
      CLoginModal() {
        this.changeLoginModal(false);
      },
      handleSubmit(e) {
        e.preventDefault();
        this.form.validateFields((err, values) => {
          if (!err) {
            this.loading = true
            this.tryLogin(values.loginCode, values.pwd, values.remember)
          }
        });
      },
      tryLogin(loginCode, pwd, remember) {
        this.$http.post('/users/login', {
          loginCode: loginCode,
          pwd: pwd,
          remember: remember
        }).then(res => {
          // 执行某些操作
          this.loading = false
          let data = res.data
          let _curUser = data.data.user
          let _token = data.data.token
          if (data.result === 'ok' && data.data !== null) {
            this.CLoginModal();
            this.userLogin(_curUser)
            this.userToken(_token)
            this.$notification['success']({
              message: _curUser.name,
              description: '登录成功.开始你的创作吧!',
            });
          }
        }).catch((error) => {
          this.$notification['error']({
            message: '很抱歉',
            description: '登录失败,请检查用户名和密码!',
          })
          this.loading = false
        })
      }
    },
  }
</script>

<style>
  #mirror-login {
    margin: 20px;
  }

  #mirror-login .login-form {
    max-width: 300px;
  }

  #mirror-login .login-form-forgot {
    float: right;
  }

  #mirror-login .login-form-button {
    width: 100%;
  }
</style>
