<template>
  <a-modal
    title="注册"
    centered
    :visible="this.$store.state.registerModal"
    @cancel="CRegisterModal()"
    :footer="null"
  >
    <a-form @submit="handleSubmit" :form="form">


      <!--<a-form-item-->
      <!--v-bind="formItemLayout"-->
      <!--has-feedback-->
      <!--:validate-status="validateStatus"-->
      <!--help="邮箱正在后台校验..."-->
      <!--&gt;-->
      <!--<span slot="label">-->
      <!--邮箱&nbsp;-->
      <!--<a-tooltip title='用于登录的嗷~'>-->
      <!--<a-icon type='question-circle-o'/>-->
      <!--</a-tooltip>-->
      <!--</span>-->
      <!--<a-input-->
      <!--id="validating"-->
      <!--placeholder="I'm the content is being validated"-->
      <!--/>-->
      <!--</a-form-item>-->


      <a-form-item
        v-bind="formItemLayout"
      >
        <span slot="label">
          邮箱&nbsp;
          <a-tooltip title='用于登录的嗷~'>
            <a-icon type='question-circle-o'/>
          </a-tooltip>
        </span>
        <a-input
          v-decorator="[
            'email',
            {
              rules: [{
                type: 'email', message: '邮箱不合法!',
              }, {
                required: true, message: '请输入邮箱!',
              }]
            }
          ]"
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label='密码'
      >
        <a-input
          v-decorator="[
        'pwd',
        {
          rules: [{
            required: true, message: '请输入密码!',
          }, {
            validator: this.validateToNextPassword,
          }],
        }
      ]"
          type='password'
        />
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label='确认密码'
      >
        <a-input
          v-decorator="[
        'confirm',
        {
          rules: [{
            required: true, message: '请确认你的密码!',
          }, {
            validator: compareToFirstPassword,
          }],
        }
      ]"
          type='password'
          @blur="handleConfirmBlur"
        />
      </a-form-item>
      <a-form-item v-bind="formItemLayout">
        <span slot="label">
          昵称&nbsp;
          <a-tooltip title='想让我怎么称呼您呢?'>
            <a-icon type='question-circle-o'/>
          </a-tooltip>
        </span>
        <a-input
          v-decorator="[
        'nickname',
        {
          rules: [{ required: true, message: '请输入用户名!', whitespace: true }]
        }
      ]"
        />
      </a-form-item>
      <a-form-item
        label="性别"
        v-bind="formItemLayout"
      >
        <a-select
          v-decorator="[
            'sex',
            {rules: [{ required: true, message: '请选择您的性别!' }]}
          ]"
          placeholder="请选择您的性别"
        >
          <a-select-option value="1">
            男
          </a-select-option>
          <a-select-option value="0">
            女
          </a-select-option>
        </a-select>
      </a-form-item>
      <a-form-item
        v-bind="formItemLayout"
        label='电话'
      >
        <a-input
          v-decorator="[
            'phone',
            {
              rules: [{ required: true, message: '请输入您的电话号码!' }],
            }
          ]"
          style="width: 100%"
        >
          <a-select
            v-decorator="[
          'prefix',
          { initialValue: '86' }
        ]"
            slot="addonBefore"
            style="width: 70px"
          >
            <a-select-option value='86'>+86</a-select-option>
            <a-select-option value='87'>+87</a-select-option>
          </a-select>
        </a-input>
      </a-form-item>

      <a-form-item
        placement="topLeft"
        v-bind="formItemLayout"
        label='验证码'
      >
        <a-popover title="mirrorVerify">
          <template slot="content">
            <verify
              @success="VerifySucc"
              @fail="VerifyFail"
            />
          </template>
          <a-button v-bind="tailFormItemLayout">在此获得验证码</a-button>
        </a-popover>
      </a-form-item>


      <a-form-item v-bind="tailFormItemLayout">
        <a-button type='primary' htmlType='submit' :disabled="!mirrorVerify" :loading='loading'>注册</a-button>
      </a-form-item>
    </a-form>
  </a-modal>
</template>

<script>

  import {mapMutations} from 'vuex'
  import Verify from '../verify/Verify'

  export default {
    components: {Verify},
    beforeCreate() {
      this.form = this.$form.createForm(this);
    },
    data() {
      return {
        loading: false,
        mirrorVerify: false,
        // validateStatus:'validating',//"success"//"error"
        confirmDirty: false,
        formItemLayout: {
          labelCol: {
            xs: {span: 24},
            sm: {span: 6},
          },
          wrapperCol: {
            xs: {span: 24},
            sm: {span: 16},
          },
        },
        tailFormItemLayout: {
          wrapperCol: {
            xs: {
              span: 24,
              offset: 0,
            },
            sm: {
              span: 12,
              offset: 8,
            },
          },
        },
        user: {}
      };
    },

    methods: {
      ...mapMutations([
        'changeRegisterModal',
      ]),
      CRegisterModal() {
        this.changeRegisterModal(false);
      },
      VerifySucc() {
        this.$notification['success']({
          message: '验证码',
          description: '验证通过嗷!',
        });
        this.mirrorVerify = true
      },
      VerifyFail() {
        this.$notification['error']({
          message: '验证码',
          description: '验证没通过嗷!',
        });
        this.mirrorVerify = false
      },
      handleSubmit(e) {
        this.loading = true
        e.preventDefault();
        this.form.validateFieldsAndScroll((err, values) => {
          if (!err) {
            this.user.email = values.email
            this.user.name = values.nickname
            this.user.pwd = values.pwd
            this.user.phone = values.phone
            this.user.sex = values.sex
            this.tryRegister(this.user)
          }
        });
      },

      tryRegister(user) {
        this.$http.post('/users/register', user).then(res => {
          // 执行某些操作
          this.loading = false
          let data = res.data
          if (data.result === 'ok' && data.data !== null) {
            this.$notification['success']({
              message: '注册成功',
              description: '登录成功.开始你的创作吧!',
            });
            this.CRegisterModal()
            this.form = this.$form.createForm(this);
          }
          else if (data.result === 'not_ok') {
            this.loading = false
            this.$notification['error']({
              message: '很抱歉',
              description: data.errors,
            });
          }
        }).catch((error) => {
          this.loading = false
          this.$notification['error']({
            message: '很抱歉',
            description: '注册失败,请检查用户名和密码!',
          });
        })
      },

      handleConfirmBlur(e) {
        let value = e.target.value;
        this.confirmDirty = this.confirmDirty || !!value;
      },
      compareToFirstPassword(rule, value, callback) {
        let form = this.form;
        if (value && value !== form.getFieldValue('pwd')) {
          callback('确认密码有误!');
        } else {
          callback();
        }
      },
      validateToNextPassword(rule, value, callback) {
        let form = this.form;
        if (value && this.confirmDirty) {
          form.validateFields(['confirm'], {force: true});
        }
        callback();
      },
    },
  };
</script>
