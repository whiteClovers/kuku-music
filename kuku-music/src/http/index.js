import axios from 'axios';
import qs from 'qs';

const Axios = axios.create({
  baseURL: "http://127.0.0.1:8764",
  timeout: 10000,
  responseType: "json",
  withCredentials: true, // 是否允许带cookie这些
  headers: {
    "Content-Type": "application/x-www-form-urlencoded;charset=utf-8",
  }
});

//POST传参序列化(添加请求拦截器)
Axios.interceptors.request.use(
  config => {
    window.localStorage.getItem("TOKEN")
    if (config.method === "post") {
      // 序列化
      config.data = qs.stringify(config.data);
      // 若是提交能直接接受json 格式,可以不用 qs 来序列化的
    }
    // 若是有做鉴权token , 就给头部带上token
    // 若是需要跨站点,存放到 cookie 会好一点,限制也没那么多,有些浏览环境限制了 localstorage 的使用
    // 这里localStorage一般是请求成功后我们自行写入到本地的,因为你放在vuex刷新就没了
    // 一些必要的数据写入本地,优先从本地读取
    if (localStorage.token) {
      config.headers.Authorization = localStorage.token;
    }
    return config;
  },
  error => {
    // error 的回调信息,看贵公司的定义
    message.info({
      content: error && error.data.error.message,
      duration: 3,
    });
    return Promise.reject(error.data.error.message);
  }
);

Axios.interceptors.response.use(
  // (res) => {
  //   let TOKEN = res.headers.token;
  //   if (undefined !== TOKEN && '' !== TOKEN.trim()) {
  //     window.localStorage.setItem("TOKEN", TOKEN);
  //   }
  //   if (res.data.STATUS == "LOGIN_FAIL") {
  //     router.push({
  //       name: "login"
  //     })
  //   }
  //   else if (res.data.STATUS == "FAIL") {
  //     //TODO
  //   }
  //   else if (res.data.STATUS == "SUCCESS") {
  //     //TODO
  //   }
  //   else {
  //     //TODO
  //   }
  // },
  // (error) => {
  //   console.log(error)
  // }
)

export default {
  get: function (url) {
    return new Promise(
      (resolve, reject) => {
        Axios.get(url, {}).then(res => {
          resolve(res);
        }).catch(reject);
      }
    )
  },
  paramsGet: function (url, params) {
    return new Promise(
      (resolve, reject) => {
        Axios.get(url, {
          params: params
        }).then(res => {
          resolve(res);
        }).catch(reject);
      }
    )
  },
  post: function (url, data) {
    return new Promise(
      (resolve, reject) => {
        Axios.post(url, data, {}).then(res => {
          resolve(res);
        }).catch(reject);
      }
    )
  }
}
