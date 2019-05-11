<template>
  <Row justify="center" align="middle" style="margin-top: 25px">
    <Col span="16" offset="4">


      <Layout>
        <Sider hide-trigger :style="{background: '#fff'}">
          <Menu theme="light" width="auto" :open-names="['1']">
            <MenuGroup title="个人设置">
              <MenuItem name="1">
                <Icon type="md-document" />
                信息设置
              </MenuItem>
              <MenuItem name="2">
                <Icon type="md-chatbubbles" />
                歌单管理
              </MenuItem>
            </MenuGroup>

          </Menu>
        </Sider>
        <Layout >
          <Content style="background-color: #ffffff;padding: 45px;">
            <div>
              <i-form form-validate :model="formValidate" :rules="ruleValidate" :label-width="80">
                <Form-item label="昵称" prop="name">
                  <i-input :value.sync="formValidate.userNickname" placeholder="请输入昵称"></i-input>
                </Form-item>
                <Form-item label="城市" prop="city">
                  <i-input :value.sync="formValidate.addr" placeholder="请输入所在城市"></i-input>
                </Form-item>
                <Form-item label="邮箱" prop="emali">
                  <i-input :value.sync="formValidate.emali" placeholder="请输入邮箱"></i-input>
                </Form-item>
                <!--<Form-item label="城市" prop="city">-->
                <!--<i-select :model.sync="formValidate.city" placeholder="请选择所在地">-->
                <!--<i-option value="beijing">北京市</i-option>-->
                <!--<i-option value="shanghai">上海市</i-option>-->
                <!--<i-option value="shenzhen">深圳市</i-option>-->
                <!--</i-select>-->
                <!--</Form-item>-->

                <Form-item label="性别" prop="gender">
                  <Radio-group :model.sync="formValidate.gender">
                    <Radio value="1">男</Radio>
                    <Radio value="0">女</Radio>
                  </Radio-group>
                </Form-item>
                <Form-item label="生日">
                  <Row>
                    <i-col span="11">
                      <Form-item prop="date">
                        <Date-picker type="date" placeholder="选择日期" :value.sync="formValidate.birth"></Date-picker>
                      </Form-item>
                    </i-col>
                    <i-col span="2" style="text-align: center">-</i-col>

                  </Row>
                </Form-item>
                <!--<Form-item label="爱好" prop="interest">-->
                <!--<Checkbox-group :model.sync="formValidate.interest">-->
                <!--<Checkbox value="吃饭"></Checkbox>-->
                <!--<Checkbox value="睡觉"></Checkbox>-->
                <!--<Checkbox value="跑步"></Checkbox>-->
                <!--<Checkbox value="看电影"></Checkbox>-->
                <!--</Checkbox-group>-->
                <!--</Form-item>-->
                <Form-item label="介绍" prop="desc">
                  <i-input :value.sync="formValidate.desc" type="textarea" :autosize="{minRows: 2,maxRows: 5}"
                           placeholder="请输入..."></i-input>
                </Form-item>
                <Form-item label="头像" prop="avatar">
                  <Avatar size="large"
                          :src="this.formValidate.pic"/>
                  <Poptip placement="right" width="400">
                    <Button>点击进行头像上传</Button>
                    <div class="api" slot="content">
                      <Upload
                        multiple
                        type="drag"
                        name="file"
                        action="//jsonplaceholder.typicode.com/posts/"
                        :on-progress="uploading"
                      >
                        <div style="padding: 20px 0">
                          <Icon type="ios-cloud-upload" size="52" style="color: #3399ff"></Icon>
                          <p>单击或拖动文件到此处上载</p>
                        </div>
                      </Upload>
                    </div>
                  </Poptip>

                </Form-item>
                <Form-item>
                  <i-button type="primary" @click="handleSubmit('formValidate')">提交</i-button>
                  <i-button type="ghost" @click="handleReset('formValidate')" style="margin-left: 8px">重置</i-button>
                </Form-item>
              </i-form>
            </div>

          </Content>
        </Layout>
      </Layout>
    </Col>
  </Row>

</template>
<script>
  export default {
    data() {
      return {
        formValidate: {
          addr: "",
          birth: "",
          collList: "",
          desc: "",
          emali: "",
          gender: "",
          myList: "",
          password: "",
          phone: "",
          pic: "",
          realName: "",
          regTime: "",
          userId: null,
          userNickname: "",
        },
        ruleValidate: {
          name: [
            {required: true, message: '姓名不能为空', trigger: 'blur'}
          ],
          mail: [
            {required: true, message: '邮箱不能为空', trigger: 'blur'},
            {type: 'email', message: '邮箱格式不正确', trigger: 'blur'}
          ],
          city: [
            {required: true, message: '请选择城市', trigger: 'change'}
          ],
          gender: [
            {required: true, message: '请选择性别', trigger: 'change'}
          ],
          interest: [
            {required: true, type: 'array', min: 1, message: '至少选择一个爱好', trigger: 'change'},
            {type: 'array', max: 2, message: '最多选择两个爱好', trigger: 'change'}
          ],
          date: [
            {required: true, type: 'date', message: '请选择日期', trigger: 'change'}
          ],
          time: [
            {required: true, type: 'date', message: '请选择时间', trigger: 'change'}
          ],
          desc: [
            {required: true, message: '请输入个人介绍', trigger: 'blur'},
            {type: 'string', min: 10, message: '介绍不能少于10字', trigger: 'blur'}
          ]
        }
      }
    },
    mounted() {
      this.getUserInfo()
    },
    methods: {
      getUserInfo() {
        this.$http.get('/user/' + this.$route.params.id).then(res => {
          let data = res.data
          this.formValidate = data.data
          console.log(data)
        })
      },
      handleSubmit(name) {
        this.$refs[name].validate((valid) => {
          if (valid) {
            this.$Message.success('提交成功!');
          } else {
            this.$Message.error('表单验证失败!');
          }
        })
      },
      handleReset(name) {
        this.$refs[name].resetFields();
      },
      uploading() {
        this.$Message.info("图片上传中...")
      }
    }
  }
</script>
