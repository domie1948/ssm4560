<template>
  <div>
    <img class="bg" src="@/assets/img/bg.jpg">
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" class="login-form">
      <h1 class="h1">毕业设计管理系统注册</h1>
                              <el-form-item v-if="tableName=='xuesheng'" label="学生学号" prop="xueshengxueshengxuehao">
        <el-input v-model="ruleForm.xueshengxuehao" placeholder="学生学号"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='xuesheng'" label="学生姓名" prop="xueshengxueshengxingming">
        <el-input v-model="ruleForm.xueshengxingming" placeholder="学生姓名"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='xuesheng'" label="密码" prop="xueshengmima">
        <el-input v-model="ruleForm.mima" placeholder="密码"></el-input>
      </el-form-item>
                                          <el-form-item v-if="tableName=='xuesheng'" label="年级" prop="xueshengnianji">
        <el-input v-model="ruleForm.nianji" placeholder="年级"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='xuesheng'" label="班级" prop="xueshengbanji">
        <el-input v-model="ruleForm.banji" placeholder="班级"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='xuesheng'" label="身份证" prop="xueshengshenfenzheng">
        <el-input v-model="ruleForm.shenfenzheng" placeholder="身份证"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='xuesheng'" label="联系电话" prop="xueshenglianxidianhua">
        <el-input v-model="ruleForm.lianxidianhua" placeholder="联系电话"></el-input>
      </el-form-item>
                                                <el-form-item v-if="tableName=='jiaoshi'" label="教师工号" prop="jiaoshijiaoshigonghao">
        <el-input v-model="ruleForm.jiaoshigonghao" placeholder="教师工号"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='jiaoshi'" label="教师姓名" prop="jiaoshijiaoshixingming">
        <el-input v-model="ruleForm.jiaoshixingming" placeholder="教师姓名"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='jiaoshi'" label="密码" prop="jiaoshimima">
        <el-input v-model="ruleForm.mima" placeholder="密码"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='jiaoshi'" label="职称" prop="jiaoshizhicheng">
        <el-input v-model="ruleForm.zhicheng" placeholder="职称"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='jiaoshi'" label="联系电话" prop="jiaoshilianxidianhua">
        <el-input v-model="ruleForm.lianxidianhua" placeholder="联系电话"></el-input>
      </el-form-item>
                        <el-form-item v-if="tableName=='jiaoshi'" label="身份证" prop="jiaoshishenfenzheng">
        <el-input v-model="ruleForm.shenfenzheng" placeholder="身份证"></el-input>
      </el-form-item>
                                                                                                                                                                                          <el-button @click="login()" class="btn-login" type="primary">注册</el-button>
    </el-form>
  </div>
</template>
<script>
export default {
  data() {
    return {
      ruleForm: {
              },
      tableName:"",
      rules: {}
    };
  },
  mounted(){
    let table = this.$storage.get("loginTable");
    this.tableName = table;
  },
  methods: {
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 注册
    login() {
                                                                                                                                                                                                                                                                                                                                                            if(`xuesheng` == this.tableName && this.ruleForm.shenfenzheng&&(!this.$validate.checkIdCard(this.ruleForm.shenfenzheng))){
        this.$message.error(`身份证应输入身份证格式`);
        return
      }
                                                if(`xuesheng` == this.tableName && this.ruleForm.lianxidianhua&&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
        this.$message.error(`联系电话应输入电话格式`);
        return
      }
                                                                                                                                                                                                                                                                                    if(`jiaoshi` == this.tableName && this.ruleForm.lianxidianhua&&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
        this.$message.error(`联系电话应输入电话格式`);
        return
      }
                                                                        if(`jiaoshi` == this.tableName && this.ruleForm.shenfenzheng&&(!this.$validate.checkIdCard(this.ruleForm.shenfenzheng))){
        this.$message.error(`身份证应输入身份证格式`);
        return
      }
                                                                                                                                                                                                this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `${this.tableName}/register`,
            method: "post",
            data:this.ruleForm
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.$router.replace({ path: "/login" });
            } else {
              this.$message.error(data.msg);
            }
          });
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
