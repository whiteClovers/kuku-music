<template>
  <Row justify="center" align="middle" style="margin-top: 25px">
    <Col span="16" offset="4">

      <Layout>
        <Sider hide-trigger :style="{background: '#fff'}" v-model="isCollapsed">
          <Menu theme="light" width="auto" :open-names="['1']">
            <MenuGroup title="个人设置">
              <MenuItem name="1">
                <div @click="infoSet">
                  <Icon type="md-document"/>
                  信息设置
                </div>

              </MenuItem>
              <MenuItem name="2">
                <div @click="listSet">
                  <Icon type="md-chatbubbles"/>
                  歌单管理
                </div>

              </MenuItem>
            </MenuGroup>

          </Menu>
        </Sider>
        <Layout>
          <!--信息设置-->
          <Content style="background-color: #ffffff;padding: 15px;" v-show="!listShow">
            <Form ref="formValidate" :model="formValidate" :rules="ruleValidate" :label-width="80">
              <FormItem label="昵称" prop="name">
                <Input v-model="formValidate.userNickname" placeholder="输入你的昵称"></Input>
              </FormItem>
              <FormItem label="邮箱" prop="mail">
                <Input v-model="formValidate.emali" placeholder="输入你的邮箱"></Input>
              </FormItem>
              <FormItem label="城市" prop="city">
                <Input v-model="formValidate.addr" placeholder="输入你的城市"></Input>
              </FormItem>
              <FormItem label="生日">
                <Row>
                  <Col span="11">
                    <FormItem prop="date">
                      <DatePicker type="date" placeholder="选择日期" v-model="formValidate.birth"></DatePicker>
                    </FormItem>
                  </Col>
                </Row>
              </FormItem>
              <FormItem label="性别" prop="gender">
                <RadioGroup>
                  <Radio label="male" v-model="formValidate.gender == 1">男</Radio>
                  <Radio label="female" v-model="formValidate.gender == 0">女</Radio>
                </RadioGroup>
              </FormItem>

              <FormItem label="自我介绍" prop="desc">
                <Input v-model="formValidate.desc" type="textarea" :autosize="{minRows: 2,maxRows: 5}"
                       placeholder="Enter something..."></Input>
              </FormItem>

              <FormItem label="头像" prop="pic">
                <Input type="hidden" v-model="formValidate.pic"/>
                <Avatar icon="ios-person" size="large" :src="formValidate.pic" style="float: left;"/>
                <Upload action="//jsonplaceholder.typicode.com/posts/" style="float: left;margin-left: 20px"

                >
                  <Button icon="ios-cloud-upload-outline">更换头像</Button>
                </Upload>
              </FormItem>

              <FormItem style="margin-top: 20px">
                <Button type="primary" @click="handleSubmit('formValidate')">确定</Button>
                <Button @click="handleReset('formValidate')" style="margin-left: 8px">重置</Button>
              </FormItem>
            </Form>
          </Content>


          <!--歌单管理-->
          <Content style="background-color: #ffffff;padding: 5px;" v-show="listShow">
            <Button type="primary" style="margin-bottom: 10px" @click="addModal = true">新增</Button>

            <Table border :columns="columns12" :data="data6">
              <template slot-scope="{ row }" slot="creaTime">
                <strong>{{ row.creaTime|dateFmt }}</strong>
              </template>
              <template slot-scope="{ row }" slot="listName">
                <strong>{{ row.listName }}</strong>
              </template>
              <template slot-scope="{ row, index }" slot="action">
                <Button type="primary" size="small" style="margin-right: 5px" @click="show(row.listId)">修改</Button>
                <Button type="error" size="small" @click="remove(row.listId)">删除</Button>
              </template>
            </Table>
          </Content>
        </Layout>


        <Modal v-model="addModal"
               draggable scrollable title="创建歌单"
               :footer-hide="true"
        >
          <div style="height: 185px">
            <Form ref="formItem" :model="formItem">
              <FormItem prop="listName" style="padding: 10px">
                <span style="float:left;">歌单名：</span>
                <Input type="text" v-model="formItem.listName" placeholder="歌单名" style="float:left;width: 380px;">
                </Input>
              </FormItem>
              <FormItem prop="label" style="padding: 10px">
                <FormItem prop="label" style="padding: 10px">
                  <span style="float:left;">标签：</span>
                  <Input type="text" v-model="formItem.label" placeholder="标签" style="float:left;width: 380px;">
                  </Input>
                </FormItem>
                <!--<Select v-model="formItem.select" style="float:left;width: 380px;">
                  <Option value="beijing">流行</Option>
                  <Option value="shanghai">摇滚</Option>
                  <Option value="shenzhen">欧美</Option>
                </Select>-->
              </FormItem>

              <FormItem style="float: right">
                <Button type="primary" @click="handleMusicListAdd('formItem')">确定</Button>
              </FormItem>
            </Form>
          </div>
        </Modal>

        <Modal v-model="editModal"
               draggable scrollable title="修改歌单"
               :footer-hide="true"
        >
          <div style="height: 185px">
            <Form ref="formItem" :model="formItem">
              <FormItem prop="listName" style="padding: 10px">
                <span style="float:left;">歌单名：</span>
                <Input type="text" v-model="formItem.listName" placeholder="歌单名" style="float:left;width: 380px;">
                </Input>
              </FormItem>
              <FormItem prop="label" style="padding: 10px">
                <span style="float:left;margin-left: 11px">标签：</span>
                <Input type="text" v-model="formItem.label" placeholder="标签" style="float:left;width: 380px;">
                </Input>
              </FormItem>

              <FormItem style="float: right">
                <Button type="primary" @click="handleMusicListEdit('formItem')">确定</Button>
              </FormItem>
            </Form>
          </div>
        </Modal>

      </Layout>
    </Col>
  </Row>

</template>
<script>
  import TableHead from "iview/src/components/table/table-head";
  import TableBody from "iview/src/components/table/table-body";
  export default {
    components: {TableBody, TableHead},
    data() {
      return {
        formItem: {
          listName: '',
          label: '',
        },

        addModal: false,
        editModal: false,

        MusiclistId: '',

        // 歌单管理
        columns12: [
          {
            title: '歌单名',
            slot: 'listName'
          },
          {
            title: '标签',
            key: 'label'
          },
          {
            title: '创建时间',
            slot: 'creaTime'
          },
          {
            title: '操作',
            slot: 'action',
            width: 150,
            align: 'center'
          }
        ],

        data6: [

        ],

        // 控制左侧切换
        listShow: false,

        isCollapsed: false,

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
          userId: "",
          userNickname: "",
        },
        ruleValidate: {
          name: [
            {required: false, message: '姓名不能为空', trigger: 'blur'}
          ],
          mail: [
            {required: false, message: '邮箱不能为空', trigger: 'blur'},
            {type: 'email', message: '邮箱格式不正确', trigger: 'blur'}
          ],
          city: [
            {required: false, message: '请选择城市', trigger: 'change'}
          ],
          gender: [
            {required: false, message: '请选择性别', trigger: 'change'}
          ],
          interest: [
            {required: false, type: 'array', min: 1, message: '至少选择一个爱好', trigger: 'change'},
            {type: 'array', max: 2, message: '最多选择两个爱好', trigger: 'change'}
          ],
          date: [
            {required: false, type: 'date', message: '请选择日期', trigger: 'change'}
          ],
          time: [
            {required: false, type: 'date', message: '请选择时间', trigger: 'change'}
          ],
          desc: [
            {required: false, message: '请输入个人介绍', trigger: 'blur'},
            // {type: 'string', min: 10, message: '介绍不能少于10字', trigger: 'blur'}
          ]
        }
      }
    },
    mounted() {
      this.getUserInfo()

    },
    computed: {
      menuitemClasses: function () {
        return [
          'menu-item',
          this.isCollapsed ? 'collapsed-menu' : ''
        ]
      }
    },
    methods: {

      list(){
        this.$http.get('/musicList/list').then(res => {
          let data = res.data
          console.log(res.data.data)
          this.data6 = res.data.data
        })
      },

      show (index) {
        this.MusiclistId = index;
        this.editModal = true;

        this.$http.get('/musicList/list/' + index).then(res => {
          let data = res.data
          // console.log(res.data.data)
          this.formItem = res.data.data;
        })

        /*this.$Modal.info({
          title: 'User Info',
          content: `Name：${this.data6[index].name}<br>Age：${this.data6[index].age}<br>Address：${this.data6[index].address}`
        })*/
      },
      remove (index) {
        // this.data6.splice(index, 1);
        this.$http.singlePost('/musicList/delete/' + index).then(res => {
          console.log(res)
          this.$Notice.success({
            desc: '删除成功!'
          })
        })
        this.list();
      },

      handleMusicListAdd(e){
        console.log('e :'+e)
        this.$http.post('/musicList/add/', {
          listName: this.formItem.listName,
          label: this.formItem.label
        }).then(res => {
          let data = res.data
          this.$Notice.success({
            desc: '新增成功!'
          })
        }).catch((error) => {
          console.log(error)
          this.$Notice.error({
            message: '很抱歉',
            desc: '新增失败,请检查用户名和密码是否符合要求!',
          })
        })

        this.addModal = false;
        this.list();
      },

      handleMusicListEdit: function (e) {
        this.$http.post('/musicList/edit/' + this.MusiclistId, {
          listName: this.formItem.listName,
          label: this.formItem.label
        }).then(res => {
          let data = res.data
          this.$Notice.success({
            desc: '修改成功!'

          })
        }).catch((error) => {
          console.log(error)
          this.$Notice.error({
            message: '很抱歉',
            desc: '修改失败,请检查用户名和密码是否符合要求!',
          })
        })

        this.editModal = false;
        this.list();
      },


      changePic() {
        // 在上传成功后替换头像图片

      },

      infoSet() {
        this.listShow=false;
      },

      listSet() {
        this.listShow=true;
        this.list()

      },

      /* 显示用户信息 */
      getUserInfo() {
        this.$http.get('/user/' + this.$store.state.curUser.userId).then(res => {
          let data = res.data
          console.log(res.data)
          this.formValidate = data.data
          this.userId = this.formValidate.userId
          console.log(data)
        })
      },

      /* 用户编辑 */
      handleSubmit(f) {
        this.editUser(this.formValidate)
        console.log(this.formValidate)
      },
      editUser(user) {
        this.$http.post('/edit', user).then(res => {
          let data = res.data
          console.log("edit: " + data)
          this.formValidate = data.data
          if (data.result === 'ok') {
            this.$Notice.success({
              desc: '修改成功!',
            });
          }
        }).catch((error) => {
          this.$Notice.error({
            message: '很抱歉',
            desc: '修改失败!',
          })
        })
      },

      /* 重置 */
      handleReset(name) {
        this.$refs[name].resetFields();
      },

      /* 图片上传 */
      uploading() {
        this.$Message.info("图片上传中...")
      }
    }
  }
</script>
