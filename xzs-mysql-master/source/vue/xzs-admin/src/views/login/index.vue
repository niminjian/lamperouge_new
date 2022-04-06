<template>
  <div class="login-container">
    <el-form
      ref="loginForm"
      :model="loginForm"
      :rules="loginRules"
      class="login-form"
      auto-complete="on"
      label-position="left"
    >
      <div class="title-container">
        <h3 class="title">Lamperouge教考分离系统</h3>
      </div>

      <el-form-item prop="userName">
        <span class="svg-container">
          <svg-icon icon-class="user" />
        </span>
        <el-input
          ref="userName"
          v-model="loginForm.userName"
          placeholder="用户名"
          name="userName"
          type="text"
          tabindex="1"
          auto-complete="on"
        />
      </el-form-item>

      <el-form-item prop="password">
        <span class="svg-container">
          <svg-icon icon-class="password" />
        </span>
        <el-input
          :key="passwordType"
          ref="password"
          v-model="loginForm.password"
          :type="passwordType"
          placeholder="密码"
          name="password"
          tabindex="2"
          auto-complete="on"
          @keyup.native="checkCapslock"
          @keyup.enter.native="handleLogin"
        />
        <span class="show-pwd" @click="showPwd">
          <svg-icon
            :icon-class="passwordType === 'password' ? 'eye' : 'eye-open'"
          />
        </span>
      </el-form-item>

      <el-checkbox
        v-model="loginForm.remember"
        style="margin-bottom: 20px; margin-left: 5px; color: #00a0e9"
        >记住密码</el-checkbox
      >

      <el-button
        :loading="loading"
        type="primary"
        style="width: 100%; margin-bottom: 30px"
        @click.native.prevent="handleLogin"
        >登录</el-button
      >
      <el-button
        :loading="loading"
        type="primary"
        style="width: 100%; margin-bottom: 30px; margin-left: 0px"
        @click="faceLogin"
        >人脸识别系统</el-button
      >
    </el-form>

    <!--    <div class="account-foot-copyright">-->
    <!--      <span>Copyright © Lamperouge教考分离系统</span>-->
    <!--    </div>-->
  </div>
</template>

<script>
import { mapMutations } from "vuex";
import loginApi from "@/api/login";

export default {
  name: "Login",
  data() {
    const validateUsername = (rule, value, callback) => {
      if (value.length < 5) {
        callback(new Error("用户名不能少于5个字符"));
      } else {
        callback();
      }
    };
    const validatePassword = (rule, value, callback) => {
      if (value.length < 5) {
        callback(new Error("密码不能少于5个字符"));
      } else {
        callback();
      }
    };
    return {
      loginForm: {
        userName: "",
        password: "",
        remember: false, //默认不记住密码
      },
      loginRules: {
        userName: [
          { required: true, trigger: "blur", validator: validateUsername },
        ],
        password: [
          { required: true, trigger: "blur", validator: validatePassword },
        ],
      },
      passwordType: "password",
      loading: false,
      showDialog: false,
    };
  },
  created() {
    // window.addEventListener('storage', this.afterQRScan)
  },
  mounted() {
    if (this.loginForm.userName === "") {
      this.$refs.userName.focus();
    } else if (this.loginForm.password === "") {
      this.$refs.password.focus();
    }
  },
  destroyed() {
    // window.removeEventListener('storage', this.afterQRScan)
  },
  methods: {
    showPwd() {
      if (this.passwordType === "password") {
        this.passwordType = "";
      } else {
        this.passwordType = "password";
      }
      this.$nextTick(() => {
        this.$refs.password.focus();
      });
    },
    handleLogin() {
      let _this = this;
      this.$refs.loginForm.validate((valid) => {
        if (valid) {
          this.loading = true;
          loginApi
            .login(this.loginForm)
            .then(function (result) {
              if (result && result.code === 1) {
                _this.setUserName(_this.loginForm.userName);
                _this.$router.push({ path: "/" });
              } else {
                _this.loading = false;
                _this.$message({
                  message: result.message,
                  type: "error",
                });
              }
            })
            .catch(function (reason) {
              _this.loading = false;
            });
        } else {
          return false;
        }
      });
    },
    faceLogin() {
      window.location.href = "http://localhost:8000/demo";
    },
    ...mapMutations("user", ["setUserName"]),
  },
};
</script>

<style lang="scss">
/* 修复input 背景不协调 和光标变色 */

$bg: rgb(218, 237, 255);
$light_gray: rgb(0, 0, 0);
$cursor: rgb(19, 18, 18);

@supports (-webkit-mask: none) and (not (cater-color: $cursor)) {
  .login-container .el-input input {
    color: $cursor;
  }
}

/* reset element-ui css */
.login-container {
  .el-input {
    display: inline-block;
    height: 47px;
    width: 85%;

    input {
      background: transparent;
      border: 0px;
      -webkit-appearance: none;
      border-radius: 0px;
      padding: 12px 5px 12px 15px;
      color: $light_gray;
      height: 47px;
      caret-color: $cursor;

      &:-webkit-autofill {
        box-shadow: 0 0 0px 1000px $bg inset !important;
        -webkit-text-fill-color: $cursor !important;
      }
    }
  }

  .el-form-item {
    border: 1px solid rgba(0, 0, 0, 0.1);
    background: rgba(0, 0, 0, 0.1);
    border-radius: 5px;
    color: #7f7a7a;
  }
}
</style>

<style lang="scss" scoped>
$bg: #2d3a4b;
$dark_gray: #1f1f1f;
$light_gray: #181717;

.login-container {
  min-height: 100%;
  width: 100%;
  background-color: $bg;
  overflow: hidden;
  background: url("../../assets/login.jpg");
  background-size: 100% 100%;
  background-color: unset;
  position: fixed;

  .login-form {
    position: relative;
    width: 520px;
    max-width: 100%;
    padding: 30px 50px 10px 50px;
    margin: 120px auto auto auto;
    overflow: hidden;
    background: rgba(255, 255, 255, 0.3);
  }

  .tips {
    font-size: 14px;
    color: #fff;
    margin-bottom: 10px;

    span {
      &:first-of-type {
        margin-right: 16px;
      }
    }
  }

  .svg-container {
    padding: 6px 5px 6px 15px;
    color: $dark_gray;
    vertical-align: middle;
    width: 30px;
    display: inline-block;
  }

  .title-container {
    position: relative;

    .title {
      font-size: 26px;
      color: $light_gray;
      margin: 0px auto 40px auto;
      text-align: center;
      font-weight: bold;
    }
  }

  .show-pwd {
    position: absolute;
    right: 10px;
    top: 7px;
    font-size: 16px;
    color: $dark_gray;
    cursor: pointer;
    user-select: none;
  }

  .thirdparty-button {
    position: absolute;
    right: 0;
    bottom: 6px;
  }

  @media only screen and (max-width: 470px) {
    .thirdparty-button {
      display: none;
    }
  }
}
</style>
