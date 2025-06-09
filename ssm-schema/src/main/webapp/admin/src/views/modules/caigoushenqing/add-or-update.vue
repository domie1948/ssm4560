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
        <el-form-item  v-if="type!='info'"  label="商品编号" prop="shangpinbianhao">
          <el-input v-model="ruleForm.shangpinbianhao" 
              placeholder="商品编号" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.shangpinbianhao" label="商品编号" prop="shangpinbianhao">
              <el-input v-model="ruleForm.shangpinbianhao" 
                placeholder="商品编号" readonly></el-input>
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
                        <el-col :span="24">  
        <el-form-item v-if="type!='info'" label="图片" prop="tupian">
          <file-upload
          tip="点击上传图片"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.tupian?ruleForm.tupian:''"
          @change="tupianUploadChange"
          ></file-upload>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.tupian" label="图片" prop="tupian">
            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.tupian.split(',')" :src="item" width="100" height="100">
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
        <el-form-item  v-if="type!='info'"  label="价格" prop="jiage">
          <el-input v-model="ruleForm.jiage" 
              placeholder="价格" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.jiage" label="价格" prop="jiage">
              <el-input v-model="ruleForm.jiage" 
                placeholder="价格" readonly></el-input>
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
        <el-form-item  v-if="type!='info'"  label="采购员姓名" prop="caigouyuanxingming">
          <el-input v-model="ruleForm.caigouyuanxingming" 
              placeholder="采购员姓名" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.caigouyuanxingming" label="采购员姓名" prop="caigouyuanxingming">
              <el-input v-model="ruleForm.caigouyuanxingming" 
                placeholder="采购员姓名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="type!='info'" label="供应商账号" prop="gongyingshangzhanghao">
          <el-select  @change="gongyingshangzhanghaoChange" v-model="ruleForm.gongyingshangzhanghao" placeholder="请选择供应商账号">
            <el-option
                v-for="(item,index) in gongyingshangzhanghaoOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.gongyingshangzhanghao" label="供应商账号" prop="gongyingshangzhanghao">
              <el-input v-model="ruleForm.gongyingshangzhanghao" 
                placeholder="供应商账号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="供应商姓名" prop="gongyingshangxingming">
          <el-input v-model="ruleForm.gongyingshangxingming" 
              placeholder="供应商姓名" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.gongyingshangxingming" label="供应商姓名" prop="gongyingshangxingming">
              <el-input v-model="ruleForm.gongyingshangxingming" 
                placeholder="供应商姓名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="申请日期" prop="shenqingriqi">
          <el-input v-model="ruleForm.shenqingriqi" 
              placeholder="申请日期" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.shenqingriqi" label="申请日期" prop="shenqingriqi">
              <el-input v-model="ruleForm.shenqingriqi" 
                placeholder="申请日期" readonly></el-input>
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
                                shangpinbianhao: '',
                                shangpinmingcheng: '',
                                tupian: '',
                                shuliang: '',
                                jiage: '',
                                zongjine: '',
                                caigouyuangonghao: '',
                                caigouyuanxingming: '',
                                gongyingshangzhanghao: '',
                                gongyingshangxingming: '',
                                shenqingriqi: '',
                                sfsh: '',
                                shhf: '',
                      },
                                                                                                                                                      gongyingshangzhanghaoOptions: [],
                                                                            rules: {
                  caigoudanbianhao: [
                                                                                              ],
                  shangpinbianhao: [
                                                                                              ],
                  shangpinmingcheng: [
                                                                                              ],
                  tupian: [
                                                                                              ],
                  shuliang: [
                                        { validator: validateIntNumber, trigger: 'blur' },
                                                                                  ],
                  jiage: [
                                        { validator: validateIntNumber, trigger: 'blur' },
                                                                                  ],
                  zongjine: [
                                        { validator: validateIntNumber, trigger: 'blur' },
                                                                                  ],
                  caigouyuangonghao: [
                                                                                              ],
                  caigouyuanxingming: [
                                                                                              ],
                  gongyingshangzhanghao: [
                                                                                              ],
                  gongyingshangxingming: [
                                                                                              ],
                  shenqingriqi: [
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
        return 1*this.ruleForm.shuliang*this.ruleForm.jiage
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
                    if(o=='shangpinbianhao'){
            this.ruleForm.shangpinbianhao = obj[o];
            continue;
          }
                    if(o=='shangpinmingcheng'){
            this.ruleForm.shangpinmingcheng = obj[o];
            continue;
          }
                    if(o=='tupian'){
            this.ruleForm.tupian = obj[o];
            continue;
          }
                    if(o=='shuliang'){
            this.ruleForm.shuliang = obj[o];
            continue;
          }
                    if(o=='jiage'){
            this.ruleForm.jiage = obj[o];
            continue;
          }
                    if(o=='zongjine'){
            this.ruleForm.zongjine = obj[o];
            continue;
          }
                    if(o=='caigouyuangonghao'){
            this.ruleForm.caigouyuangonghao = obj[o];
            continue;
          }
                    if(o=='caigouyuanxingming'){
            this.ruleForm.caigouyuanxingming = obj[o];
            continue;
          }
                    if(o=='gongyingshangzhanghao'){
            this.ruleForm.gongyingshangzhanghao = obj[o];
            continue;
          }
                    if(o=='gongyingshangxingming'){
            this.ruleForm.gongyingshangxingming = obj[o];
            continue;
          }
                    if(o=='shenqingriqi'){
            this.ruleForm.shenqingriqi = obj[o];
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
                                                this.ruleForm.caigouyuanxingming = json.caigouyuanxingming
                                                                                                                                            } else {
          this.$message.error(data.msg);
        }
      });
                                                                                                                                                                                                            this.$http({
              url: `option/gongyingshangxinxi/gongyingshangzhanghao`,
              method: "get"
            }).then(({ data }) => {
              if (data && data.code === 0) {
                this.gongyingshangzhanghaoOptions = data.data;
              } else {
                this.$message.error(data.msg);
              }
            });
                                                                                                    },
                                                                                    // 下二随
    gongyingshangzhanghaoChange () {
      this.$http({
        url: `follow/gongyingshangxinxi/gongyingshangzhanghao?columnValue=`+ this.ruleForm.gongyingshangzhanghao,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
                                                                                                                                                                                                                                                                if(data.data.gongyingshangxingming){
                this.ruleForm.gongyingshangxingming = data.data.gongyingshangxingming
              }
                                                                                                } else {
          this.$message.error(data.msg);
        }
      });
    },
                                            // 多级联动参数
                                                                                                                                                        info(id) {
      this.$http({
        url: `caigoushenqing/info/${id}`,
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
              this.ruleForm.zongjine = this.zongjine
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
            url: `caigoushenqing/${!this.ruleForm.id ? "save" : "update"}`,
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
                  this.parent.caigoushenqingCrossAddOrUpdateFlag = false;
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
      this.parent.caigoushenqingCrossAddOrUpdateFlag = false;
    },
                                                            tupianUploadChange(fileUrls) {
                this.ruleForm.tupian = fileUrls;
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
