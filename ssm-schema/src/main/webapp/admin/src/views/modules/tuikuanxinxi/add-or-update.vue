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
        <el-form-item  v-if="type!='info'"  label="合同编号" prop="hetongbianhao">
          <el-input v-model="ruleForm.hetongbianhao" 
              placeholder="合同编号" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.hetongbianhao" label="合同编号" prop="hetongbianhao">
              <el-input v-model="ruleForm.hetongbianhao" 
                placeholder="合同编号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="房源名称" prop="fangyuanmingcheng">
          <el-input v-model="ruleForm.fangyuanmingcheng" 
              placeholder="房源名称" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.fangyuanmingcheng" label="房源名称" prop="fangyuanmingcheng">
              <el-input v-model="ruleForm.fangyuanmingcheng" 
                placeholder="房源名称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="地址" prop="dizhi">
          <el-input v-model="ruleForm.dizhi" 
              placeholder="地址" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.dizhi" label="地址" prop="dizhi">
              <el-input v-model="ruleForm.dizhi" 
                placeholder="地址" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="退款金额" prop="tuikuanjine">
          <el-input v-model="ruleForm.tuikuanjine" 
              placeholder="退款金额" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.tuikuanjine" label="退款金额" prop="tuikuanjine">
              <el-input v-model="ruleForm.tuikuanjine" 
                placeholder="退款金额" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                          <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="租客账号" prop="zukezhanghao">
          <el-input v-model="ruleForm.zukezhanghao" 
              placeholder="租客账号" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.zukezhanghao" label="租客账号" prop="zukezhanghao">
              <el-input v-model="ruleForm.zukezhanghao" 
                placeholder="租客账号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="租客姓名" prop="zukexingming">
          <el-input v-model="ruleForm.zukexingming" 
              placeholder="租客姓名" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.zukexingming" label="租客姓名" prop="zukexingming">
              <el-input v-model="ruleForm.zukexingming" 
                placeholder="租客姓名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="房东账号" prop="fangdongzhanghao">
          <el-input v-model="ruleForm.fangdongzhanghao" 
              placeholder="房东账号" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.fangdongzhanghao" label="房东账号" prop="fangdongzhanghao">
              <el-input v-model="ruleForm.fangdongzhanghao" 
                placeholder="房东账号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="房东姓名" prop="fangdongxingming">
          <el-input v-model="ruleForm.fangdongxingming" 
              placeholder="房东姓名" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.fangdongxingming" label="房东姓名" prop="fangdongxingming">
              <el-input v-model="ruleForm.fangdongxingming" 
                placeholder="房东姓名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="type!='info'" label="退款日期" prop="tuikuanriqi">
            <el-date-picker
                value-format="yyyy-MM-dd HH:mm:ss"
                v-model="ruleForm.tuikuanriqi" 
                type="datetime"
                placeholder="退款日期">
            </el-date-picker>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.tuikuanriqi" label="退款日期" prop="tuikuanriqi">
              <el-input v-model="ruleForm.tuikuanriqi" 
                placeholder="退款日期" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                          </el-row>
                                                                                                                                                                                                                                                <el-row>
            <el-col :span="24">
              <el-form-item v-if="type!='info'"  label="费用详情" prop="feiyongxiangqing">
                <editor 
                    style="min-width: 200px; max-width: 600px;"
                    v-model="ruleForm.feiyongxiangqing" 
                    class="editor" 
                    action="file/upload">
                </editor>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.feiyongxiangqing" label="费用详情" prop="feiyongxiangqing">
                    <span v-html="ruleForm.feiyongxiangqing"></span>
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
                        hetongbianhao: '',
                                fangyuanmingcheng: '',
                                dizhi: '',
                                tuikuanjine: '',
                                feiyongxiangqing: '',
                                zukezhanghao: '',
                                zukexingming: '',
                                fangdongzhanghao: '',
                                fangdongxingming: '',
                                tuikuanriqi: '',
                                ispay: '',
                      },
                                                                                                                                                                      rules: {
                  hetongbianhao: [
                                                                                              ],
                  fangyuanmingcheng: [
                                                                                              ],
                  dizhi: [
                                                                                              ],
                  tuikuanjine: [
                                                                                              ],
                  feiyongxiangqing: [
                                                                                              ],
                  zukezhanghao: [
                                                                                              ],
                  zukexingming: [
                                                                                              ],
                  fangdongzhanghao: [
                                                                                              ],
                  fangdongxingming: [
                                                                                              ],
                  tuikuanriqi: [
                                                                                              ],
                  ispay: [
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
                    if(o=='hetongbianhao'){
            this.ruleForm.hetongbianhao = obj[o];
            continue;
          }
                    if(o=='fangyuanmingcheng'){
            this.ruleForm.fangyuanmingcheng = obj[o];
            continue;
          }
                    if(o=='dizhi'){
            this.ruleForm.dizhi = obj[o];
            continue;
          }
                    if(o=='tuikuanjine'){
            this.ruleForm.tuikuanjine = obj[o];
            continue;
          }
                    if(o=='feiyongxiangqing'){
            this.ruleForm.feiyongxiangqing = obj[o];
            continue;
          }
                    if(o=='zukezhanghao'){
            this.ruleForm.zukezhanghao = obj[o];
            continue;
          }
                    if(o=='zukexingming'){
            this.ruleForm.zukexingming = obj[o];
            continue;
          }
                    if(o=='fangdongzhanghao'){
            this.ruleForm.fangdongzhanghao = obj[o];
            continue;
          }
                    if(o=='fangdongxingming'){
            this.ruleForm.fangdongxingming = obj[o];
            continue;
          }
                    if(o=='tuikuanriqi'){
            this.ruleForm.tuikuanriqi = obj[o];
            continue;
          }
                    if(o=='ispay'){
            this.ruleForm.ispay = obj[o];
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
                                                                                                                                                                                              this.ruleForm.fangdongzhanghao = json.fangdongzhanghao
                                                this.ruleForm.fangdongxingming = json.fangdongxingming
                                                                          } else {
          this.$message.error(data.msg);
        }
      });
                                                                                                                                                                                                                                    },
                                                                                                // 多级联动参数
                                                                                                                          info(id) {
      this.$http({
        url: `tuikuanxinxi/info/${id}`,
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
                              // ${column.compare}
                                                                                                                                                                                                                                          this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `tuikuanxinxi/${!this.ruleForm.id ? "save" : "update"}`,
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
                  this.parent.tuikuanxinxiCrossAddOrUpdateFlag = false;
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
      this.parent.tuikuanxinxiCrossAddOrUpdateFlag = false;
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
