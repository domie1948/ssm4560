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
        <el-form-item  v-if="type!='info'"  label="课题题目" prop="ketitimu">
          <el-input v-model="ruleForm.ketitimu" 
              placeholder="课题题目" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.ketitimu" label="课题题目" prop="ketitimu">
              <el-input v-model="ruleForm.ketitimu" 
                placeholder="课题题目" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'" label="开始时间" prop="kaishishijian">
            <el-date-picker
                format="yyyy 年 MM 月 dd 日"
                value-format="yyyy-MM-dd"
                v-model="ruleForm.kaishishijian" 
                type="date"
                placeholder="开始时间">
            </el-date-picker> 
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.kaishishijian" label="开始时间" prop="kaishishijian">
              <el-input v-model="ruleForm.kaishishijian" 
                placeholder="开始时间" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'" label="截至时间" prop="jiezhishijian">
            <el-date-picker
                format="yyyy 年 MM 月 dd 日"
                value-format="yyyy-MM-dd"
                v-model="ruleForm.jiezhishijian" 
                type="date"
                placeholder="截至时间">
            </el-date-picker> 
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.jiezhishijian" label="截至时间" prop="jiezhishijian">
              <el-input v-model="ruleForm.jiezhishijian" 
                placeholder="截至时间" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                          <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="学生学号" prop="xueshengxuehao">
          <el-input v-model="ruleForm.xueshengxuehao" 
              placeholder="学生学号" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.xueshengxuehao" label="学生学号" prop="xueshengxuehao">
              <el-input v-model="ruleForm.xueshengxuehao" 
                placeholder="学生学号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="学生姓名" prop="xueshengxingming">
          <el-input v-model="ruleForm.xueshengxingming" 
              placeholder="学生姓名" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.xueshengxingming" label="学生姓名" prop="xueshengxingming">
              <el-input v-model="ruleForm.xueshengxingming" 
                placeholder="学生姓名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="type!='info'"  label="教师工号" prop="jiaoshigonghao">
          <el-select v-model="ruleForm.jiaoshigonghao" placeholder="请选择教师工号">
            <el-option
                v-for="(item,index) in jiaoshigonghaoOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.jiaoshigonghao" label="教师工号" prop="jiaoshigonghao">
              <el-input v-model="ruleForm.jiaoshigonghao" 
                placeholder="教师工号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="type!='info'" label="提交时间" prop="tijiaoshijian">
            <el-date-picker
                value-format="yyyy-MM-dd HH:mm:ss"
                v-model="ruleForm.tijiaoshijian" 
                type="datetime"
                placeholder="提交时间">
            </el-date-picker>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.tijiaoshijian" label="提交时间" prop="tijiaoshijian">
              <el-input v-model="ruleForm.tijiaoshijian" 
                placeholder="提交时间" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                                            </el-row>
                                                                                                                                                                                                                    <el-row>
            <el-col :span="24">
              <el-form-item v-if="type!='info'"  label="中期报告" prop="zhongqibaogao">
                <editor 
                    style="min-width: 200px; max-width: 600px;"
                    v-model="ruleForm.zhongqibaogao" 
                    class="editor" 
                    action="file/upload">
                </editor>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.zhongqibaogao" label="中期报告" prop="zhongqibaogao">
                    <span v-html="ruleForm.zhongqibaogao"></span>
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
                        ketitimu: '',
                                kaishishijian: '',
                                jiezhishijian: '',
                                zhongqibaogao: '',
                                xueshengxuehao: '',
                                xueshengxingming: '',
                                jiaoshigonghao: '',
                                tijiaoshijian: '',
                                sfsh: '',
                                shhf: '',
                      },
                                                                                                            jiaoshigonghaoOptions: [],
                                                              rules: {
                  ketitimu: [
                                                                                              ],
                  kaishishijian: [
                                                                                              ],
                  jiezhishijian: [
                                                                                              ],
                  zhongqibaogao: [
                                                                                              ],
                  xueshengxuehao: [
                                                                                              ],
                  xueshengxingming: [
                                                                                              ],
                  jiaoshigonghao: [
                                                                                              ],
                  tijiaoshijian: [
                                                                                              ],
                  sfsh: [
                                                                                              ],
                  shhf: [
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
                    if(o=='ketitimu'){
            this.ruleForm.ketitimu = obj[o];
            continue;
          }
                    if(o=='kaishishijian'){
            this.ruleForm.kaishishijian = obj[o];
            continue;
          }
                    if(o=='jiezhishijian'){
            this.ruleForm.jiezhishijian = obj[o];
            continue;
          }
                    if(o=='zhongqibaogao'){
            this.ruleForm.zhongqibaogao = obj[o];
            continue;
          }
                    if(o=='xueshengxuehao'){
            this.ruleForm.xueshengxuehao = obj[o];
            continue;
          }
                    if(o=='xueshengxingming'){
            this.ruleForm.xueshengxingming = obj[o];
            continue;
          }
                    if(o=='jiaoshigonghao'){
            this.ruleForm.jiaoshigonghao = obj[o];
            continue;
          }
                    if(o=='tijiaoshijian'){
            this.ruleForm.tijiaoshijian = obj[o];
            continue;
          }
                    if(o=='sfsh'){
            this.ruleForm.sfsh = obj[o];
            continue;
          }
                    if(o=='shhf'){
            this.ruleForm.shhf = obj[o];
            continue;
          }
                  }
                                                                                                                                                                              }
            // 获取用户信息
      this.$http({
        url: `${this.$storage.get('sessionTable')}/session`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          var json = data.data;
                                                                                                                            this.ruleForm.xueshengxuehao = json.xueshengxuehao
                                                this.ruleForm.xueshengxingming = json.xueshengxingming
                                                                                                                      } else {
          this.$message.error(data.msg);
        }
      });
                                                                                                                                                      this.$http({
              url: `option/jiaoshi/jiaoshigonghao`,
              method: "get"
            }).then(({ data }) => {
              if (data && data.code === 0) {
                this.jiaoshigonghaoOptions = data.data;
              } else {
                this.$message.error(data.msg);
              }
            });
         
                                                                                  },
                                                                                        // 多级联动参数
                                                                                                                info(id) {
      this.$http({
        url: `zhongqibaogao/info/${id}`,
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
                                                                                                                                                                                                                        this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `zhongqibaogao/${!this.ruleForm.id ? "save" : "update"}`,
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
                  this.parent.zhongqibaogaoCrossAddOrUpdateFlag = false;
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
      this.parent.zhongqibaogaoCrossAddOrUpdateFlag = false;
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
