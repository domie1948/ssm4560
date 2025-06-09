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
        <el-form-item  v-if="type!='info'"  label="标题" prop="biaoti">
          <el-input v-model="ruleForm.biaoti" 
              placeholder="标题" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.biaoti" label="标题" prop="biaoti">
              <el-input v-model="ruleForm.biaoti" 
                placeholder="标题" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="员工工号" prop="yuangonggonghao">
          <el-input v-model="ruleForm.yuangonggonghao" 
              placeholder="员工工号" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.yuangonggonghao" label="员工工号" prop="yuangonggonghao">
              <el-input v-model="ruleForm.yuangonggonghao" 
                placeholder="员工工号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="员工姓名" prop="yuangongxingming">
          <el-input v-model="ruleForm.yuangongxingming" 
              placeholder="员工姓名" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.yuangongxingming" label="员工姓名" prop="yuangongxingming">
              <el-input v-model="ruleForm.yuangongxingming" 
                placeholder="员工姓名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="基本薪资" prop="jibenxinzi">
          <el-input v-model="ruleForm.jibenxinzi" 
              placeholder="基本薪资" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.jibenxinzi" label="基本薪资" prop="jibenxinzi">
              <el-input v-model="ruleForm.jibenxinzi" 
                placeholder="基本薪资" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="加班费" prop="jiabanfei">
          <el-input v-model="ruleForm.jiabanfei" 
              placeholder="加班费" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.jiabanfei" label="加班费" prop="jiabanfei">
              <el-input v-model="ruleForm.jiabanfei" 
                placeholder="加班费" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="奖金" prop="jiangjin">
          <el-input v-model="ruleForm.jiangjin" 
              placeholder="奖金" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.jiangjin" label="奖金" prop="jiangjin">
              <el-input v-model="ruleForm.jiangjin" 
                placeholder="奖金" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="高温补贴" prop="gaowenbutie">
          <el-input v-model="ruleForm.gaowenbutie" 
              placeholder="高温补贴" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.gaowenbutie" label="高温补贴" prop="gaowenbutie">
              <el-input v-model="ruleForm.gaowenbutie" 
                placeholder="高温补贴" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="请假薪资" prop="qingjiaxinzi">
          <el-input v-model="ruleForm.qingjiaxinzi" 
              placeholder="请假薪资" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.qingjiaxinzi" label="请假薪资" prop="qingjiaxinzi">
              <el-input v-model="ruleForm.qingjiaxinzi" 
                placeholder="请假薪资" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="其他" prop="qita">
          <el-input v-model="ruleForm.qita" 
              placeholder="其他" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.qita" label="其他" prop="qita">
              <el-input v-model="ruleForm.qita" 
                placeholder="其他" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="type!='info'" label="实发工资" prop="shifagongzi">
            <el-input v-model="shifagongzi"
                placeholder="实发工资" readonly></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.shifagongzi" label="实发工资" prop="shifagongzi">
              <el-input v-model="ruleForm.shifagongzi" 
                placeholder="实发工资" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="type!='info'" label="登记日期" prop="dengjiriqi">
            <el-date-picker
                value-format="yyyy-MM-dd HH:mm:ss"
                v-model="ruleForm.dengjiriqi" 
                type="datetime"
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
                        biaoti: '',
                                yuangonggonghao: '',
                                yuangongxingming: '',
                                jibenxinzi: '',
                                jiabanfei: '',
                                jiangjin: '',
                                gaowenbutie: '',
                                qingjiaxinzi: '',
                                qita: '',
                                shifagongzi: '',
                                dengjiriqi: '',
                      },
                                                                                                                                                                      rules: {
                  biaoti: [
                                                                                              ],
                  yuangonggonghao: [
                                                                                              ],
                  yuangongxingming: [
                                                                                              ],
                  jibenxinzi: [
                                                                                              ],
                  jiabanfei: [
                                                                                              ],
                  jiangjin: [
                                                                                              ],
                  gaowenbutie: [
                                                                                              ],
                  qingjiaxinzi: [
                                                                                              ],
                  qita: [
                                                                                              ],
                  shifagongzi: [
                                                                                              ],
                  dengjiriqi: [
                                                                                              ],
              }
    };
  },
  props: ["parent"],
  computed: {
                                                                                                                            shifagongzi: {
                                                                                                                                                                                                                                                                                                              get: function () {
        return 0+parseFloat(this.ruleForm.jibenxinzi)+parseFloat(this.ruleForm.jiabanfei)+parseFloat(this.ruleForm.jiangjin)+parseFloat(this.ruleForm.gaowenbutie)-this.ruleForm.qingjiaxinzi+parseFloat(this.ruleForm.qita) || ''
      }
    },
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
                    if(o=='biaoti'){
            this.ruleForm.biaoti = obj[o];
            continue;
          }
                    if(o=='yuangonggonghao'){
            this.ruleForm.yuangonggonghao = obj[o];
            continue;
          }
                    if(o=='yuangongxingming'){
            this.ruleForm.yuangongxingming = obj[o];
            continue;
          }
                    if(o=='jibenxinzi'){
            this.ruleForm.jibenxinzi = obj[o];
            continue;
          }
                    if(o=='jiabanfei'){
            this.ruleForm.jiabanfei = obj[o];
            continue;
          }
                    if(o=='jiangjin'){
            this.ruleForm.jiangjin = obj[o];
            continue;
          }
                    if(o=='gaowenbutie'){
            this.ruleForm.gaowenbutie = obj[o];
            continue;
          }
                    if(o=='qingjiaxinzi'){
            this.ruleForm.qingjiaxinzi = obj[o];
            continue;
          }
                    if(o=='qita'){
            this.ruleForm.qita = obj[o];
            continue;
          }
                    if(o=='shifagongzi'){
            this.ruleForm.shifagongzi = obj[o];
            continue;
          }
                    if(o=='dengjiriqi'){
            this.ruleForm.dengjiriqi = obj[o];
            continue;
          }
                  }
                                                                                                                                                                                              }
                                                                                                                                                                                                                                    },
                                                                                                // 多级联动参数
                                                                                                                          info(id) {
      this.$http({
        url: `xinzixinxi/info/${id}`,
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
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
              this.ruleForm.shifagongzi = this.shifagongzi
                              // ${column.compare}
                                                                                                                                                                                                                                          this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `xinzixinxi/${!this.ruleForm.id ? "save" : "update"}`,
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
                  this.parent.xinzixinxiCrossAddOrUpdateFlag = false;
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
      this.parent.xinzixinxiCrossAddOrUpdateFlag = false;
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
