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
        <el-form-item  v-if="type!='info'"  label="车辆编号" prop="cheliangbianhao">
          <el-input v-model="ruleForm.cheliangbianhao" 
              placeholder="车辆编号" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.cheliangbianhao" label="车辆编号" prop="cheliangbianhao">
              <el-input v-model="ruleForm.cheliangbianhao" 
                placeholder="车辆编号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="车辆品牌" prop="cheliangpinpai">
          <el-input v-model="ruleForm.cheliangpinpai" 
              placeholder="车辆品牌" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.cheliangpinpai" label="车辆品牌" prop="cheliangpinpai">
              <el-input v-model="ruleForm.cheliangpinpai" 
                placeholder="车辆品牌" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="车辆型号" prop="cheliangxinghao">
          <el-input v-model="ruleForm.cheliangxinghao" 
              placeholder="车辆型号" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.cheliangxinghao" label="车辆型号" prop="cheliangxinghao">
              <el-input v-model="ruleForm.cheliangxinghao" 
                placeholder="车辆型号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="车牌号" prop="chepaihao">
          <el-input v-model="ruleForm.chepaihao" 
              placeholder="车牌号" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.chepaihao" label="车牌号" prop="chepaihao">
              <el-input v-model="ruleForm.chepaihao" 
                placeholder="车牌号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="租赁总收入" prop="zulinzongshouru">
          <el-input v-model="ruleForm.zulinzongshouru" 
              placeholder="租赁总收入" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.zulinzongshouru" label="租赁总收入" prop="zulinzongshouru">
              <el-input v-model="ruleForm.zulinzongshouru" 
                placeholder="租赁总收入" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="维护支出" prop="weihuzhichu">
          <el-input v-model="ruleForm.weihuzhichu" 
              placeholder="维护支出" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.weihuzhichu" label="维护支出" prop="weihuzhichu">
              <el-input v-model="ruleForm.weihuzhichu" 
                placeholder="维护支出" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="其他费用" prop="qitafeiyong">
          <el-input v-model="ruleForm.qitafeiyong" 
              placeholder="其他费用" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.qitafeiyong" label="其他费用" prop="qitafeiyong">
              <el-input v-model="ruleForm.qitafeiyong" 
                placeholder="其他费用" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="type!='info'" label="实际总收入" prop="shijizongshouru">
            <el-input v-model="shijizongshouru"
                placeholder="实际总收入" readonly></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.shijizongshouru" label="实际总收入" prop="shijizongshouru">
              <el-input v-model="ruleForm.shijizongshouru" 
                placeholder="实际总收入" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'" label="登记时间" prop="dengjishijian">
            <el-date-picker
                format="yyyy 年 MM 月 dd 日"
                value-format="yyyy-MM-dd"
                v-model="ruleForm.dengjishijian" 
                type="date"
                placeholder="登记时间">
            </el-date-picker> 
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.dengjishijian" label="登记时间" prop="dengjishijian">
              <el-input v-model="ruleForm.dengjishijian" 
                placeholder="登记时间" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                          </el-row>
                                                                                                                                                                                                                                                                                                        <el-row>
            <el-col :span="24">
              <el-form-item v-if="type!='info'"  label="备注" prop="beizhu">
                <editor 
                    style="min-width: 200px; max-width: 600px;"
                    v-model="ruleForm.beizhu" 
                    class="editor" 
                    action="file/upload">
                </editor>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.beizhu" label="备注" prop="beizhu">
                    <span v-html="ruleForm.beizhu"></span>
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
                        cheliangbianhao: '',
                                cheliangpinpai: '',
                                cheliangxinghao: '',
                                chepaihao: '',
                                zulinzongshouru: '',
                                weihuzhichu: '',
                                qitafeiyong: '',
                                shijizongshouru: '',
                                dengjishijian: '',
                                beizhu: '',
                      },
                                                                                                                                                        rules: {
                  cheliangbianhao: [
                                                                                              ],
                  cheliangpinpai: [
                                                                                              ],
                  cheliangxinghao: [
                                                                                              ],
                  chepaihao: [
                                                                                              ],
                  zulinzongshouru: [
                                        { validator: validateIntNumber, trigger: 'blur' },
                                                                                  ],
                  weihuzhichu: [
                                        { validator: validateIntNumber, trigger: 'blur' },
                                                                                  ],
                  qitafeiyong: [
                                        { validator: validateIntNumber, trigger: 'blur' },
                                                                                  ],
                  shijizongshouru: [
                                        { validator: validateIntNumber, trigger: 'blur' },
                                                                                  ],
                  dengjishijian: [
                                                                                              ],
                  beizhu: [
                                                                                              ],
              }
    };
  },
  props: ["parent"],
  computed: {
                                                                                                    shijizongshouru: {
                                                                                                                                                                                                                                                                get: function () {
        return 0+parseFloat(this.ruleForm.zulinzongshouru)-this.ruleForm.weihuzhichu+parseFloat(this.ruleForm.qitafeiyong) || ''
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
                    if(o=='cheliangbianhao'){
            this.ruleForm.cheliangbianhao = obj[o];
            continue;
          }
                    if(o=='cheliangpinpai'){
            this.ruleForm.cheliangpinpai = obj[o];
            continue;
          }
                    if(o=='cheliangxinghao'){
            this.ruleForm.cheliangxinghao = obj[o];
            continue;
          }
                    if(o=='chepaihao'){
            this.ruleForm.chepaihao = obj[o];
            continue;
          }
                    if(o=='zulinzongshouru'){
            this.ruleForm.zulinzongshouru = obj[o];
            continue;
          }
                    if(o=='weihuzhichu'){
            this.ruleForm.weihuzhichu = obj[o];
            continue;
          }
                    if(o=='qitafeiyong'){
            this.ruleForm.qitafeiyong = obj[o];
            continue;
          }
                    if(o=='shijizongshouru'){
            this.ruleForm.shijizongshouru = obj[o];
            continue;
          }
                    if(o=='dengjishijian'){
            this.ruleForm.dengjishijian = obj[o];
            continue;
          }
                    if(o=='beizhu'){
            this.ruleForm.beizhu = obj[o];
            continue;
          }
                  }
                                                                                                                                                                              }
                                                                                                                                                                                                                  },
                                                                                        // 多级联动参数
                                                                                                                info(id) {
      this.$http({
        url: `qicheshouru/info/${id}`,
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
              this.ruleForm.shijizongshouru = this.shijizongshouru
                              // ${column.compare}
                              // ${column.compare}
                                                                                                                                                                                                                        this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `qicheshouru/${!this.ruleForm.id ? "save" : "update"}`,
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
                  this.parent.qicheshouruCrossAddOrUpdateFlag = false;
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
      this.parent.qicheshouruCrossAddOrUpdateFlag = false;
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
