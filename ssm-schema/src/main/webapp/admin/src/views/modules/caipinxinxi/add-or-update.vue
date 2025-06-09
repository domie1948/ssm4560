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
        <el-form-item v-if="type!='info'" label="菜品编号" prop="caipinbianhao">
            <el-input v-model="ruleForm.caipinbianhao" 
                placeholder="菜品编号" readonly></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.caipinbianhao" label="菜品编号" prop="caipinbianhao">
              <el-input v-model="ruleForm.caipinbianhao" 
                placeholder="菜品编号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="城市" prop="chengshi">
          <el-input v-model="ruleForm.chengshi" 
              placeholder="城市" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.chengshi" label="城市" prop="chengshi">
              <el-input v-model="ruleForm.chengshi" 
                placeholder="城市" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="菜品名称" prop="caipinmingcheng">
          <el-input v-model="ruleForm.caipinmingcheng" 
              placeholder="菜品名称" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.caipinmingcheng" label="菜品名称" prop="caipinmingcheng">
              <el-input v-model="ruleForm.caipinmingcheng" 
                placeholder="菜品名称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="type!='info'"  label="菜品类型" prop="caipinleixing">
          <el-select v-model="ruleForm.caipinleixing" placeholder="请选择菜品类型">
            <el-option
                v-for="(item,index) in caipinleixingOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.caipinleixing" label="菜品类型" prop="caipinleixing">
              <el-input v-model="ruleForm.caipinleixing" 
                placeholder="菜品类型" readonly></el-input>
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
        <el-form-item  v-if="type!='info'"  label="商家号" prop="shangjiahao">
          <el-input v-model="ruleForm.shangjiahao" 
              placeholder="商家号" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.shangjiahao" label="商家号" prop="shangjiahao">
              <el-input v-model="ruleForm.shangjiahao" 
                placeholder="商家号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="商铺名称" prop="shangpumingcheng">
          <el-input v-model="ruleForm.shangpumingcheng" 
              placeholder="商铺名称" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.shangpumingcheng" label="商铺名称" prop="shangpumingcheng">
              <el-input v-model="ruleForm.shangpumingcheng" 
                placeholder="商铺名称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="店铺地址" prop="dianpudizhi">
          <el-input v-model="ruleForm.dianpudizhi" 
              placeholder="店铺地址" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.dianpudizhi" label="店铺地址" prop="dianpudizhi">
              <el-input v-model="ruleForm.dianpudizhi" 
                placeholder="店铺地址" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                                            </el-row>
                                                                                                                                                                                                                                                                                                                                                  <el-row>
            <el-col :span="24">
              <el-form-item v-if="type!='info'"  label="介绍" prop="jieshao">
                <editor 
                    style="min-width: 200px; max-width: 600px;"
                    v-model="ruleForm.jieshao" 
                    class="editor" 
                    action="file/upload">
                </editor>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.jieshao" label="介绍" prop="jieshao">
                    <span v-html="ruleForm.jieshao"></span>
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
                        caipinbianhao: this.getUUID(),
                                chengshi: '',
                                caipinmingcheng: '',
                                caipinleixing: '',
                                jiage: '',
                                shuliang: '',
                                tupian: '',
                                shangjiahao: '',
                                shangpumingcheng: '',
                                dianpudizhi: '',
                                jieshao: '',
                                clicktime: '',
                      },
                                                                  caipinleixingOptions: [],
                                                                                                                                    rules: {
                  caipinbianhao: [
                                                                                              ],
                  chengshi: [
                                                                                              ],
                  caipinmingcheng: [
                                                                                              ],
                  caipinleixing: [
                                                                                              ],
                  jiage: [
                                        { validator: validateIntNumber, trigger: 'blur' },
                                                                                  ],
                  shuliang: [
                                        { validator: validateIntNumber, trigger: 'blur' },
                                                                                  ],
                  tupian: [
                                                                                              ],
                  shangjiahao: [
                                                                                              ],
                  shangpumingcheng: [
                                                                                              ],
                  dianpudizhi: [
                                                                                              ],
                  jieshao: [
                                                                                              ],
                  clicktime: [
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
                    if(o=='caipinbianhao'){
            this.ruleForm.caipinbianhao = obj[o];
            continue;
          }
                    if(o=='chengshi'){
            this.ruleForm.chengshi = obj[o];
            continue;
          }
                    if(o=='caipinmingcheng'){
            this.ruleForm.caipinmingcheng = obj[o];
            continue;
          }
                    if(o=='caipinleixing'){
            this.ruleForm.caipinleixing = obj[o];
            continue;
          }
                    if(o=='jiage'){
            this.ruleForm.jiage = obj[o];
            continue;
          }
                    if(o=='shuliang'){
            this.ruleForm.shuliang = obj[o];
            continue;
          }
                    if(o=='tupian'){
            this.ruleForm.tupian = obj[o];
            continue;
          }
                    if(o=='shangjiahao'){
            this.ruleForm.shangjiahao = obj[o];
            continue;
          }
                    if(o=='shangpumingcheng'){
            this.ruleForm.shangpumingcheng = obj[o];
            continue;
          }
                    if(o=='dianpudizhi'){
            this.ruleForm.dianpudizhi = obj[o];
            continue;
          }
                    if(o=='jieshao'){
            this.ruleForm.jieshao = obj[o];
            continue;
          }
                    if(o=='clicktime'){
            this.ruleForm.clicktime = obj[o];
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
                                                                                                                                                                                              this.ruleForm.shangjiahao = json.shangjiahao
                                                this.ruleForm.shangpumingcheng = json.shangpumingcheng
                                                this.ruleForm.dianpudizhi = json.dianpudizhi
                                                                          } else {
          this.$message.error(data.msg);
        }
      });
                                                                                                this.$http({
              url: `option/caipinleixing/caipinleixing`,
              method: "get"
            }).then(({ data }) => {
              if (data && data.code === 0) {
                this.caipinleixingOptions = data.data;
              } else {
                this.$message.error(data.msg);
              }
            });
         
                                                                                                                                                                            },
                                                                                                        // 多级联动参数
                                                                                                                                    info(id) {
      this.$http({
        url: `caipinxinxi/info/${id}`,
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
                              // ${column.compare}
                                                                                                                                                                                                                                                            this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `caipinxinxi/${!this.ruleForm.id ? "save" : "update"}`,
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
                  this.parent.caipinxinxiCrossAddOrUpdateFlag = false;
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
      this.parent.caipinxinxiCrossAddOrUpdateFlag = false;
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
