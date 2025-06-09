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
        <el-form-item v-if="type!='info'" label="体检编号" prop="tijianbianhao">
            <el-input v-model="ruleForm.tijianbianhao" 
                placeholder="体检编号" readonly></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.tijianbianhao" label="体检编号" prop="tijianbianhao">
              <el-input v-model="ruleForm.tijianbianhao" 
                placeholder="体检编号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="体检项目" prop="tijianxiangmu">
          <el-input v-model="ruleForm.tijianxiangmu" 
              placeholder="体检项目" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.tijianxiangmu" label="体检项目" prop="tijianxiangmu">
              <el-input v-model="ruleForm.tijianxiangmu" 
                placeholder="体检项目" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                                                              <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="用户名" prop="yonghuming">
          <el-input v-model="ruleForm.yonghuming" 
              placeholder="用户名" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.yonghuming" label="用户名" prop="yonghuming">
              <el-input v-model="ruleForm.yonghuming" 
                placeholder="用户名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="医生工号" prop="yishenggonghao">
          <el-input v-model="ruleForm.yishenggonghao" 
              placeholder="医生工号" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.yishenggonghao" label="医生工号" prop="yishenggonghao">
              <el-input v-model="ruleForm.yishenggonghao" 
                placeholder="医生工号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'" label="体检时间" prop="tijianshijian">
            <el-date-picker
                format="yyyy 年 MM 月 dd 日"
                value-format="yyyy-MM-dd"
                v-model="ruleForm.tijianshijian" 
                type="date"
                placeholder="体检时间">
            </el-date-picker> 
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.tijianshijian" label="体检时间" prop="tijianshijian">
              <el-input v-model="ruleForm.tijianshijian" 
                placeholder="体检时间" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        </el-row>
                                                                                                                                                                          <el-row>
            <el-col :span="24">
              <el-form-item v-if="type!='info'"  label="体检结果" prop="tijianjieguo">
                <editor 
                    style="min-width: 200px; max-width: 600px;"
                    v-model="ruleForm.tijianjieguo" 
                    class="editor" 
                    action="file/upload">
                </editor>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.tijianjieguo" label="体检结果" prop="tijianjieguo">
                    <span v-html="ruleForm.tijianjieguo"></span>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
                                <el-row>
            <el-col :span="24">
              <el-form-item v-if="type!='info'"  label="医生建议" prop="yishengjianyi">
                <editor 
                    style="min-width: 200px; max-width: 600px;"
                    v-model="ruleForm.yishengjianyi" 
                    class="editor" 
                    action="file/upload">
                </editor>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.yishengjianyi" label="医生建议" prop="yishengjianyi">
                    <span v-html="ruleForm.yishengjianyi"></span>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
                                <el-row>
            <el-col :span="24">
              <el-form-item v-if="type!='info'"  label="医生医嘱" prop="yishengyizhu">
                <editor 
                    style="min-width: 200px; max-width: 600px;"
                    v-model="ruleForm.yishengyizhu" 
                    class="editor" 
                    action="file/upload">
                </editor>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.yishengyizhu" label="医生医嘱" prop="yishengyizhu">
                    <span v-html="ruleForm.yishengyizhu"></span>
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
                        tijianbianhao: this.getUUID(),
                                tijianxiangmu: '',
                                tijianjieguo: '',
                                yishengjianyi: '',
                                yishengyizhu: '',
                                yonghuming: '',
                                yishenggonghao: '',
                                tijianshijian: '',
                      },
                                                                                                                            rules: {
                  tijianbianhao: [
                                                                                              ],
                  tijianxiangmu: [
                                                                                              ],
                  tijianjieguo: [
                                                                                              ],
                  yishengjianyi: [
                                                                                              ],
                  yishengyizhu: [
                                                                                              ],
                  yonghuming: [
                                                                                              ],
                  yishenggonghao: [
                                                                                              ],
                  tijianshijian: [
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
                    if(o=='tijianbianhao'){
            this.ruleForm.tijianbianhao = obj[o];
            continue;
          }
                    if(o=='tijianxiangmu'){
            this.ruleForm.tijianxiangmu = obj[o];
            continue;
          }
                    if(o=='tijianjieguo'){
            this.ruleForm.tijianjieguo = obj[o];
            continue;
          }
                    if(o=='yishengjianyi'){
            this.ruleForm.yishengjianyi = obj[o];
            continue;
          }
                    if(o=='yishengyizhu'){
            this.ruleForm.yishengyizhu = obj[o];
            continue;
          }
                    if(o=='yonghuming'){
            this.ruleForm.yonghuming = obj[o];
            continue;
          }
                    if(o=='yishenggonghao'){
            this.ruleForm.yishenggonghao = obj[o];
            continue;
          }
                    if(o=='tijianshijian'){
            this.ruleForm.tijianshijian = obj[o];
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
                                                                                                                                                                        this.ruleForm.yishenggonghao = json.yishenggonghao
                                                    } else {
          this.$message.error(data.msg);
        }
      });
                                                                                                                                                                              },
                                                                        // 多级联动参数
                                                                                            info(id) {
      this.$http({
        url: `tijianbaogao/info/${id}`,
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
                                                                                                                                                                                    this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `tijianbaogao/${!this.ruleForm.id ? "save" : "update"}`,
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
                  this.parent.tijianbaogaoCrossAddOrUpdateFlag = false;
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
      this.parent.tijianbaogaoCrossAddOrUpdateFlag = false;
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
