<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
    >
      <el-row>
                  <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="商品号" prop="shangpinhao">
          <el-input v-model="ruleForm.shangpinhao" 
              placeholder="商品号" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.shangpinhao" label="商品号" prop="shangpinhao">
              <el-input v-model="ruleForm.shangpinhao" 
                placeholder="商品号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="商品名称" prop="shangpinmingcheng">
          <el-input v-model="ruleForm.shangpinmingcheng" 
              placeholder="商品名称" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.shangpinmingcheng" label="商品名称" prop="shangpinmingcheng">
              <el-input v-model="ruleForm.shangpinmingcheng" 
                placeholder="商品名称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="数量" prop="shuliang">
          <el-input v-model="ruleForm.shuliang" 
              placeholder="数量" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.shuliang" label="数量" prop="shuliang">
              <el-input v-model="ruleForm.shuliang" 
                placeholder="数量" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="质检员账号" prop="zhijianyuanzhanghao">
          <el-input v-model="ruleForm.zhijianyuanzhanghao" 
              placeholder="质检员账号" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.zhijianyuanzhanghao" label="质检员账号" prop="zhijianyuanzhanghao">
              <el-input v-model="ruleForm.zhijianyuanzhanghao" 
                placeholder="质检员账号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="质检员姓名" prop="zhijianyuanxingming">
          <el-input v-model="ruleForm.zhijianyuanxingming" 
              placeholder="质检员姓名" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.zhijianyuanxingming" label="质检员姓名" prop="zhijianyuanxingming">
              <el-input v-model="ruleForm.zhijianyuanxingming" 
                placeholder="质检员姓名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'" label="登记日期" prop="dengjiriqi">
            <el-date-picker
                format="yyyy 年 MM 月 dd 日"
                value-format="yyyy-MM-dd"
                v-model="ruleForm.dengjiriqi" 
                type="date"
                placeholder="登记日期">
            </el-date-picker> 
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.dengjiriqi" label="登记日期" prop="dengjiriqi">
              <el-input v-model="ruleForm.dengjiriqi" 
                placeholder="登记日期" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        </el-row>
                                                                                                                                                                                          <el-form-item>
                <el-button v-if="type!='info'" type="primary" @click="onSubmit">提交</el-button>
        <el-button v-if="type!='info'" @click="back()">取消</el-button>
        <el-button v-if="type=='info'" @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
    
    
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
  data() {
    let self = this
    var validateIdCard = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!checkIdCard(value)) {
        callback(new Error("请输入正确的身份证号码"));
      } else {
        callback();
      }
    };
    var validateUrl = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isURL(value)) {
        callback(new Error("请输入正确的URL地址"));
      } else {
        callback();
      }
    };
    var validatePhone = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isMobile(value)) {
        callback(new Error("请输入正确的电话号码"));
      } else {
        callback();
      }
    };
    var validateEmail = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isEmail(value)) {
        callback(new Error("请输入正确的邮箱地址"));
      } else {
        callback();
      }
    };
    var validateNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isNumber(value)) {
        callback(new Error("请输入数字"));
      } else {
        callback();
      }
    };
    var validateIntNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isIntNumer(value)) {
        callback(new Error("请输入整数"));
      } else {
        callback();
      }
    };
    return {
      id: '',
      type: '',
            ruleForm: {
                        shangpinhao: '',
                                shangpinmingcheng: '',
                                shuliang: '',
                                zhijianyuanzhanghao: '',
                                zhijianyuanxingming: '',
                                dengjiriqi: '',
                      },
                                                                                                rules: {
                  shangpinhao: [
                                                                                              ],
                  shangpinmingcheng: [
                                                                                              ],
                  shuliang: [
                                        { validator: validateIntNumber, trigger: 'blur' },
                                                                                  ],
                  zhijianyuanzhanghao: [
                                                                                              ],
                  zhijianyuanxingming: [
                                                                                              ],
                  dengjiriqi: [
                                                                                              ],
              }
    };
  },
  props: ["parent"],
  computed: {
                                                                              },
  methods: {
        // 下载
    download(file){
      window.open(`${file}`)
    },
    // 初始化
    init(id,type) {
      if (id) {
        this.id = id;
        this.type = type;
      }
      if(this.type=='info'||this.type=='else'){
        this.info(id);
      }else if(this.type=='cross'){
        var obj = this.$storage.getObj('crossObj');
        for (var o in obj){
                    if(o=='shangpinhao'){
            this.ruleForm.shangpinhao = obj[o];
            continue;
          }
                    if(o=='shangpinmingcheng'){
            this.ruleForm.shangpinmingcheng = obj[o];
            continue;
          }
                    if(o=='shuliang'){
            this.ruleForm.shuliang = obj[o];
            continue;
          }
                    if(o=='zhijianyuanzhanghao'){
            this.ruleForm.zhijianyuanzhanghao = obj[o];
            continue;
          }
                    if(o=='zhijianyuanxingming'){
            this.ruleForm.zhijianyuanxingming = obj[o];
            continue;
          }
                    if(o=='dengjiriqi'){
            this.ruleForm.dengjiriqi = obj[o];
            continue;
          }
                  }
                                                        this.ruleForm.shuliang = 0
                                                                      }
            // 获取用户信息
      this.$http({
        url: `${this.$storage.get('sessionTable')}/session`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          var json = data.data;
                                                                                                      this.ruleForm.zhijianyuanzhanghao = json.zhijianyuanzhanghao
                                                this.ruleForm.zhijianyuanxingming = json.zhijianyuanxingming
                                                    } else {
          this.$message.error(data.msg);
        }
      });
                                                                                                                                          },
                                                        // 多级联动参数
                                                                        info(id) {
      this.$http({
        url: `rukuxinxi/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.ruleForm = data.data;
        } else {
          this.$message.error(data.msg);
        }
      });
    },
        // 提交
    onSubmit() {
                  // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                                                                                    var obj = this.$storage.getObj('crossObj');
      var table = this.$storage.getObj('crossTable');
      obj.shuliang = parseFloat(obj.shuliang) + parseFloat(this.ruleForm.shuliang)
      this.$http({
          url: `${table}/update`,
          method: "post",
          data: obj
        }).then(({ data }) => {});
                                                                        this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `rukuxinxi/${!this.ruleForm.id ? "save" : "update"}`,
            method: "post",
            data: this.ruleForm
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.$message({
                message: "操作成功",
                type: "success",
                duration: 1500,
                onClose: () => {
                  this.parent.showFlag = true;
                  this.parent.addOrUpdateFlag = false;
                  this.parent.rukuxinxiCrossAddOrUpdateFlag = false;
                  this.parent.search();
                }
              });
            } else {
              this.$message.error(data.msg);
            }
          });
        }
      });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.rukuxinxiCrossAddOrUpdateFlag = false;
    },
                                                                              }
};
</script>
<style lang="scss">
.editor{
  height: 500px;
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
</style>
