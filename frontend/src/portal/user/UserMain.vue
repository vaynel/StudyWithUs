<template>
  <div class="container_main">
    <div
      class="npc1"
      @click="showModal"
    >
      <img src="../../assets/images/npc1.png">
    </div>

    <div
      ref="kirby_position"
      class="kirby"
    >
      <img src="../../assets/images/kirby_org.png">
    </div>

    <!-- 첫 대화창 -->
    <MessageModal v-if="modalOpen">
      <template #character>
        <img
          src="../../assets/images/npc1_m.png"
          class="npc1_m"
        >
      </template>
      <template #contents>
        <div :style="`margin: 25px 30px`">
          <div :style="`margin-bottom: 10px`">
            성에 들어가려면 아이디가 있어야해. 아이디를 말해줘
          </div>

          <router-link to="/user/signup">
            <div
              id="toSignUp"
              class="select"
              :style="`margin-bottom: 3px`"
              @click="showSignupModal"
            >
              <img src="../../assets/images/select_btn.png">
              아이디..? 없는데...
            </div>
          </router-link>

          <router-link to="/user/login">
            <div
              id="toLogin"
              class="select"
              @click="showLoginModal"
            >
              <img src="../../assets/images/select_btn.png">
              어디다가 입력하면 되는거야?
            </div>
          </router-link>
        </div>
      </template>
    </MessageModal>

    <!-- 회원가입 클릭 시 -->
    <MessageModal v-if="signUpModalOpen">
      <template #character>
        <img
          src="../../assets/images/npc1_m.png"
          class="npc1_m_2"
        >
      </template>
      <template #contents>
        <div :style="`margin: 40px 30px; font-size: 12px`">
          <div :style="`margin-bottom: 3px`">
            아래 회원가입 란을 띄어놨으니 얼른 적어줘~
          </div>
          <div>빠진거 없는지 꼼꼼히 확인 하는것도 잊지마!</div>
          <div
            class="next_btn"
            @click="showSignupValidationModal"
          >
            <img src="../../assets/images/next_btn.png">
          </div>
        </div>
      </template>
    </MessageModal>

    <!-- 로그인 클릭시 -->
    <MessageModal v-if="loginModalOpen">
      <template #character>
        <img
          src="../../assets/images/npc1_m.png"
          class="npc1_m_2"
        >
      </template>
      <template #contents>
        <div :style="`margin: 30px 30px; font-size: 12px`">
          <div :style="`margin-bottom: 3px`">
            어쩐지~ 어디서 본 듯 했단 말이지...
          </div>
          <div :style="`margin-bottom: 7px`">
            늘 그랬듯이 아래에다 적어주면 된다구.
          </div>
          <div>
            오늘도 화이팅 하자고! 항상 응원해! 엣헴...
          </div>
          <div
            class="next_btn"
            @click="showAskSignupModal"
          >
            <img src="../../assets/images/next_btn.png">
          </div>
        </div>
      </template>
    </MessageModal>

    <!-- 회원가입 validation -->
    <MessageModal v-if="signupValidation">
      <template #character>
        <img
          src="../../assets/images/npc1_m.png"
          class="npc1_m"
        >
      </template>
      <template #contents>
        <div :style="`margin: 25px 30px; font-size: 12px`">
          <div :style="`margin-bottom: 3px`">
            <div>{{ signup.errorEmail }}</div>
            <div>{{ signup.errorEmailForm }}</div>
            <div>{{ signup.errorPassword }}</div>
            <div>{{ signup.errorNickname }}</div>

            <div
              class="next_btn"
              @click="showAskLoginModal"
            >
              <img src="../../assets/images/next_btn.png">
            </div>

            <div v-if="!signup.errorEmailForm && !signup.errorEmail && !signup.errorPassword && !signup.errorNickname">
              <div :style="`margin-top: 5px`">
                좋아 드디어 모든 조건을 만족 하는구만!
              </div>
              <div :style="`margin-bottom: 5px`">
                얼른 회원가입 버튼을 눌러봐!
              </div>
              <div>정말이지... 이제 시작이라구~ 언제나 응원할게!</div>
            </div>
          </div>
        </div>
      </template>
    </MessageModal>

    <!-- 회원가입 -> 로그인 -->
    <MessageModal v-if="askLogin">
      <template #character>
        <img
          src="../../assets/images/npc1_m.png"
          class="npc1_m"
        >
      </template>
      <template #contents>
        <div :style="`margin: 27px 30px`">
          <div :style="`margin-bottom: 10px`">
            뭐야! 이전에 가입 했었던거야? 어쩐지 낯이 익은것 같기도하고~?
          </div>

          <router-link to="/user/signup">
            <div
              id="toSignUp"
              class="select"
              :style="`margin-bottom: 3px`"
              @click="showSignupModal"
            >
              <img src="../../assets/images/select_btn.png">
              미안.. 아무래도 잘못 누른것 같아..
            </div>
          </router-link>

          <router-link to="/user/login">
            <div
              id="toLogin"
              class="select"
              @click="showLoginModal"
            >
              <img src="../../assets/images/select_btn.png">
              응. 깜빡했지 뭐야. 이메일이랑 비밀번호를 말해줄게!
            </div>
          </router-link>
        </div>
      </template>
    </MessageModal>

    <!-- 로그인 -> 회원가입 -->
    <MessageModal v-if="askSignup">
      <template #character>
        <img
          src="../../assets/images/npc1_m.png"
          class="npc1_m_2"
        >
      </template>
      <template #contents>
        <div :style="`margin: 23px 30px`">
          <div :style="`margin-bottom: 5px`">
            뭐야! 회원가입을 안했던거야? <br>
            이런~ 그럼 들어갈수가 없어! 어떻게 할래?
          </div>

          <router-link to="/user/signup">
            <div
              id="toSignUp"
              class="select"
              :style="`margin-bottom: 3px`"
              @click="showSignupModal"
            >
              <img src="../../assets/images/select_btn.png">
              흠.. 회원가입을 해야겠어!
            </div>
          </router-link>

          <router-link to="/user/login">
            <div
              id="toLogin"
              class="select"
              @click="showLoginModal"
            >
              <img src="../../assets/images/select_btn.png">
              미안 잘못 누른거 같아.. 얼른 입력할게!
            </div>
          </router-link>
        </div>
      </template>
    </MessageModal>
  </div>
</template>

<script>
import MessageModal from "@/components/modal/MessageModal";
import { signupStore } from "@/store/user/signup";

export default {

  name: 'UserMain',

  components: {
    MessageModal
  },
  setup() {
    const signup = signupStore();
    return {
      signup: signup
    }
  },

  data: function() {
    return {
      modalOpen: false,
      signUpModalOpen: false,
      loginModalOpen: false,
      signupValidation: false,
      askLogin: false,
      askSignup: false
    }
  },

  methods: {
    showModal() {
      this.modalOpen = true;
    },

    showSignupModal() {
      this.modalOpen = false;
      this.signUpModalOpen = true;
      this.askLogin = false;
      this.askSignup = false;
    },

    showLoginModal() {
      this.modalOpen = false;
      this.signUpModalOpen = false;
      this.loginModalOpen = true;
      this.askLogin = false;
      this.askSignup = false;
    },

    showSignupValidationModal() {
      this.signUpModalOpen = false;
      this.signupValidation = true;
    },

    showAskLoginModal() {
      this.signupValidation = false;
      this.askLogin = true;
    },

    showAskSignupModal() {
      this.loginModalOpen = false;
      this.askSignup = true;
    }
  }

}
</script>