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
        <el-form-item v-if="type!='info'" label="销售单号" prop="xiaoshoudanhao">
            <el-input v-model="ruleForm.xiaoshoudanhao" 
                placeholder="销售单号" readonly></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.xiaoshoudanhao" label="销售单号" prop="xiaoshoudanhao">
              <el-input v-model="ruleForm.xiaoshoudanhao" 
                placeholder="销售单号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="type!='info'"  label="商品号" prop="shangpinhao">
          <el-select v-model="ruleForm.shangpinhao" placeholder="请选择商品号">
            <el-option
                v-for="(item,index) in shangpinhaoOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.shangpinhao" label="商品号" prop="shangpinhao">
              <el-input v-model="ruleForm.shangpinhao" 
                placeholder="商品号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="type!='info'" label="客户号" prop="kehuhao">
          <el-select  @change="kehuhaoChange" v-model="ruleForm.kehuhao" placeholder="请选择客户号">
            <el-option
                v-for="(item,index) in kehuhaoOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.kehuhao" label="客户号" prop="kehuhao">
              <el-input v-model="ruleForm.kehuhao" 
                placeholder="客户号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="客户名称" prop="kehumingcheng">
          <el-input v-model="ruleForm.kehumingcheng" 
              placeholder="客户名称" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.kehumingcheng" label="客户名称" prop="kehumingcheng">
              <el-input v-model="ruleForm.kehumingcheng" 
                placeholder="客户名称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="销售员工号" prop="xiaoshouyuangonghao">
          <el-input v-model="ruleForm.xiaoshouyuangonghao" 
              placeholder="销售员工号" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.xiaoshouyuangonghao" label="销售员工号" prop="xiaoshouyuangonghao">
              <el-input v-model="ruleForm.xiaoshouyuangonghao" 
                placeholder="销售员工号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'" label="送货日期" prop="songhuoriqi">
            <el-date-picker
                format="yyyy 年 MM 月 dd 日"
                value-format="yyyy-MM-dd"
                v-model="ruleForm.songhuoriqi" 
                type="date"
                placeholder="送货日期">
            </el-date-picker> 
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.songhuoriqi" label="送货日期" prop="songhuoriqi">
              <el-input v-model="ruleForm.songhuoriqi" 
                placeholder="送货日期" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="送货数量" prop="songhuoshuliang">
          <el-input v-model="ruleForm.songhuoshuliang" 
              placeholder="送货数量" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.songhuoshuliang" label="送货数量" prop="songhuoshuliang">
              <el-input v-model="ruleForm.songhuoshuliang" 
                placeholder="送货数量" readonly></el-input>
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
                        xiaoshoudanhao: this.getUUID(),
                                shangpinhao: '',
                                kehuhao: '',
                                kehumingcheng: '',
                                xiaoshouyuangonghao: '',
                                songhuoriqi: '',
                                songhuoshuliang: '',
                                beizhu: '',
                      },
                                      shangpinhaoOptions: [],
                                kehuhaoOptions: [],
                                                                                          rules: {
                  xiaoshoudanhao: [
                                                                                              ],
                  shangpinhao: [
                                                                                              ],
                  kehuhao: [
                                                                                              ],
                  kehumingcheng: [
                                                                                              ],
                  xiaoshouyuangonghao: [
                                                                                              ],
                  songhuoriqi: [
                                                                                              ],
                  songhuoshuliang: [
                                                                                              ],
                  beizhu: [
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
                    if(o=='xiaoshoudanhao'){
            this.ruleForm.xiaoshoudanhao = obj[o];
            continue;
          }
                    if(o=='shangpinhao'){
            this.ruleForm.shangpinhao = obj[o];
            continue;
          }
                    if(o=='kehuhao'){
            this.ruleForm.kehuhao = obj[o];
            continue;
          }
                    if(o=='kehumingcheng'){
            this.ruleForm.kehumingcheng = obj[o];
            continue;
          }
                    if(o=='xiaoshouyuangonghao'){
            this.ruleForm.xiaoshouyuangonghao = obj[o];
            continue;
          }
                    if(o=='songhuoriqi'){
            this.ruleForm.songhuoriqi = obj[o];
            continue;
          }
                    if(o=='songhuoshuliang'){
            this.ruleForm.songhuoshuliang = obj[o];
            continue;
          }
                    if(o=='beizhu'){
            this.ruleForm.beizhu = obj[o];
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
                                                                                                                            this.ruleForm.xiaoshouyuangonghao = json.xiaoshouyuangonghao
                                                                                                } else {
          this.$message.error(data.msg);
        }
      });
                                                            this.$http({
              url: `option/shangpinxinxi/shangpinhao`,
              method: "get"
            }).then(({ data }) => {
              if (data && data.code === 0) {
                this.shangpinhaoOptions = data.data;
              } else {
                this.$message.error(data.msg);
              }
            });
         
                                        this.$http({
              url: `option/kehuxinxi/kehuhao`,
              method: "get"
            }).then(({ data }) => {
              if (data && data.code === 0) {
                this.kehuhaoOptions = data.data;
              } else {
                this.$message.error(data.msg);
              }
            });
                                                                                                                      },
                            // 下二随
    kehuhaoChange () {
      this.$http({
        url: `follow/kehuxinxi/kehuhao?columnValue=`+ this.ruleForm.kehuhao,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
                                                                                                      if(data.data.kehumingcheng){
                this.ruleForm.kehumingcheng = data.data.kehumingcheng
              }
                                                                                                                      } else {
          this.$message.error(data.msg);
        }
      });
    },
                                                    // 多级联动参数
                                                                                            info(id) {
      this.$http({
        url: `xiaoshousonghuodan/info/${id}`,
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
            url: `xiaoshousonghuodan/${!this.ruleForm.id ? "save" : "update"}`,
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
                  this.parent.xiaoshousonghuodanCrossAddOrUpdateFlag = false;
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
      this.parent.xiaoshousonghuodanCrossAddOrUpdateFlag = false;
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
