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
        <el-form-item v-if="type!='info'" label="采购单编号" prop="caigoudanbianhao">
            <el-input v-model="ruleForm.caigoudanbianhao" 
                placeholder="采购单编号" readonly></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.caigoudanbianhao" label="采购单编号" prop="caigoudanbianhao">
              <el-input v-model="ruleForm.caigoudanbianhao" 
                placeholder="采购单编号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
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
        <el-form-item v-if="type!='info'"  label="供应商号" prop="gongyingshanghao">
          <el-select v-model="ruleForm.gongyingshanghao" placeholder="请选择供应商号">
            <el-option
                v-for="(item,index) in gongyingshanghaoOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.gongyingshanghao" label="供应商号" prop="gongyingshanghao">
              <el-input v-model="ruleForm.gongyingshanghao" 
                placeholder="供应商号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="采购员工号" prop="caigouyuangonghao">
          <el-input v-model="ruleForm.caigouyuangonghao" 
              placeholder="采购员工号" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.caigouyuangonghao" label="采购员工号" prop="caigouyuangonghao">
              <el-input v-model="ruleForm.caigouyuangonghao" 
                placeholder="采购员工号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="采购数量" prop="caigoushuliang">
          <el-input v-model="ruleForm.caigoushuliang" 
              placeholder="采购数量" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.caigoushuliang" label="采购数量" prop="caigoushuliang">
              <el-input v-model="ruleForm.caigoushuliang" 
                placeholder="采购数量" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="采购单价" prop="caigoudanjia">
          <el-input v-model="ruleForm.caigoudanjia" 
              placeholder="采购单价" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.caigoudanjia" label="采购单价" prop="caigoudanjia">
              <el-input v-model="ruleForm.caigoudanjia" 
                placeholder="采购单价" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="type!='info'"  label="总金额" prop="zongjine">
            <el-input v-model="zongjine"
                placeholder="总金额" readonly></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.zongjine" label="总金额" prop="zongjine">
              <el-input v-model="ruleForm.zongjine" 
                placeholder="总金额" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'" label="采购日期" prop="caigouriqi">
            <el-date-picker
                format="yyyy 年 MM 月 dd 日"
                value-format="yyyy-MM-dd"
                v-model="ruleForm.caigouriqi" 
                type="date"
                placeholder="采购日期">
            </el-date-picker> 
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.caigouriqi" label="采购日期" prop="caigouriqi">
              <el-input v-model="ruleForm.caigouriqi" 
                placeholder="采购日期" readonly></el-input>
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
                        caigoudanbianhao: this.getUUID(),
                                shangpinhao: '',
                                shangpinmingcheng: '',
                                gongyingshanghao: '',
                                caigouyuangonghao: '',
                                caigoushuliang: '',
                                caigoudanjia: '',
                                zongjine: '',
                                caigouriqi: '',
                                sfsh: '',
                                shhf: '',
                      },
                                                                  gongyingshanghaoOptions: [],
                                                                                                                      rules: {
                  caigoudanbianhao: [
                                                                                              ],
                  shangpinhao: [
                                                                                              ],
                  shangpinmingcheng: [
                                                                                              ],
                  gongyingshanghao: [
                                                                                              ],
                  caigouyuangonghao: [
                                                                                              ],
                  caigoushuliang: [
                                        { validator: validateIntNumber, trigger: 'blur' },
                                                                                  ],
                  caigoudanjia: [
                                        { validator: validateIntNumber, trigger: 'blur' },
                                                                                  ],
                  zongjine: [
                                        { validator: validateIntNumber, trigger: 'blur' },
                                                                                  ],
                  caigouriqi: [
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
                                                                                                zongjine:{
                                                                                                                                                                                      get: function () {
        return 1*this.ruleForm.caigoushuliang*this.ruleForm.caigoudanjia
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
                    if(o=='caigoudanbianhao'){
            this.ruleForm.caigoudanbianhao = obj[o];
            continue;
          }
                    if(o=='shangpinhao'){
            this.ruleForm.shangpinhao = obj[o];
            continue;
          }
                    if(o=='shangpinmingcheng'){
            this.ruleForm.shangpinmingcheng = obj[o];
            continue;
          }
                    if(o=='gongyingshanghao'){
            this.ruleForm.gongyingshanghao = obj[o];
            continue;
          }
                    if(o=='caigouyuangonghao'){
            this.ruleForm.caigouyuangonghao = obj[o];
            continue;
          }
                    if(o=='caigoushuliang'){
            this.ruleForm.caigoushuliang = obj[o];
            continue;
          }
                    if(o=='caigoudanjia'){
            this.ruleForm.caigoudanjia = obj[o];
            continue;
          }
                    if(o=='zongjine'){
            this.ruleForm.zongjine = obj[o];
            continue;
          }
                    if(o=='caigouriqi'){
            this.ruleForm.caigouriqi = obj[o];
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
                                                                                                                            this.ruleForm.caigouyuangonghao = json.caigouyuangonghao
                                                                                                                                                                  } else {
          this.$message.error(data.msg);
        }
      });
                                                                                                this.$http({
              url: `option/gongyingshangxinxi/gongyingshanghao`,
              method: "get"
            }).then(({ data }) => {
              if (data && data.code === 0) {
                this.gongyingshanghaoOptions = data.data;
              } else {
                this.$message.error(data.msg);
              }
            });
         
                                                                                                                                                          },
                                                                                                // 多级联动参数
                                                                                                                          info(id) {
      this.$http({
        url: `caigoudingdan/info/${id}`,
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
              this.ruleForm.zongjine = this.zongjine
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                                                                                                                                                                                                                                          this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `caigoudingdan/${!this.ruleForm.id ? "save" : "update"}`,
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
                  this.parent.caigoudingdanCrossAddOrUpdateFlag = false;
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
      this.parent.caigoudingdanCrossAddOrUpdateFlag = false;
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
