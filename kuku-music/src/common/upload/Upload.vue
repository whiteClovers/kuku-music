<template>
  <a-upload-dragger name="file" :multiple="true" action="//jsonplaceholder.typicode.com/posts/" @change="handleChange">
    <p class="ant-upload-drag-icon">
      <a-icon type="inbox"/>
    </p>
    <p class="ant-upload-text">单击或拖动文件到此区域进行上载</p>
    <p class="ant-upload-hint">支持单个或批量上传</p>
  </a-upload-dragger>
</template>
<script>
  export default {
    data() {
      return {}
    },
    methods: {
      handleChange(info) {
        let status = info.file.status;
        if (status !== 'uploading') {
          console.log(info.file, info.fileList);
        }
        if (status === 'done') {
          this.$message.success(`${info.file.name} 文件已成功上传.`);
        } else if (status === 'error') {
          this.$message.error(`${info.file.name} 文件已成功失败.`);
        }
      },
    },
  }
</script>
