<template>
    <div>
        <Main_nav />
        <Main_header></Main_header>
        <!-- Portfolio Section-->
        <section class="page-section portfolio" id="portfolio">
            <div class="container">
                <!-- Portfolio Section Heading-->
                <h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">Portfolio</h2>
                <!-- Icon Divider-->
                <div class="divider-custom">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                    <div class="divider-custom-line"></div>
                </div>
                <!-- Portfolio Grid Items-->
                <div class="row justify-content-center">
                    <!-- Portfolio Item-->
                    <div id="item" v-for="(item, idx) in itemData" :key="item.menuId" class="col-md-6 col-lg-4 mb-5">
                        <div class="portfolio-item mx-auto" data-bs-toggle="modal"
                            :data-bs-target="`#portfolioModal${idx + 1}`">
                            <div @click='showBasicModal(item)'
                                class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100">
                                <div class="portfolio-item-caption-content text-center text-white">
                                    <i class="fas fa-plus fa-3x"></i>
                                </div>
                            </div>
                            <img class="img-fluid" :src='`${item.src}`' alt="image" />
                        </div>
                    </div>
                </div>
                <transition name="fade">
                    <MyModal :menuName="showMenu" v-if="showModal" v-on:basicModalClose="closeBasicModal"></MyModal>
                </transition>
            </div>
        </section>
        <!-- About Section-->
        <section class="page-section bg-primary text-white mb-0" id="about">
            <div class="container">
                <!-- About Section Heading-->
                <h2 class="page-section-heading text-center text-uppercase text-white">About</h2>
                <!-- Icon Divider-->
                <div class="divider-custom divider-light">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                    <div class="divider-custom-line"></div>
                </div>
                <!-- About Section Content-->
                <div class="row">
                    <div class="col-lg-4 ms-auto">
                        <p class="lead">Freelancer is a free bootstrap theme created by Start Bootstrap. The download
                            includes the complete source files including HTML, CSS, and JavaScript as well as optional SASS
                            stylesheets for easy customization.</p>
                    </div>
                    <div class="col-lg-4 me-auto">
                        <p class="lead">You can create your own custom avatar for the masthead, change the icon in the
                            dividers, and add your email address to the contact form to make it fully functional!</p>
                    </div>
                </div>
                <!-- About Section Button-->
                <div class="text-center mt-4">
                    <a class="btn btn-xl btn-outline-light" href="https://startbootstrap.com/theme/freelancer/">
                        <i class="fas fa-download me-2"></i>
                        Free Download!
                    </a>
                </div>
            </div>
        </section>
        <!-- Contact Section-->
        <section class="page-section" id="contact">
            <div class="container">
                <!-- Contact Section Heading-->
                <h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">Contact Me</h2>
                <!-- Icon Divider-->
                <div class="divider-custom">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                    <div class="divider-custom-line"></div>
                </div>
                <!-- Contact Section Form-->
                <div class="row justify-content-center">
                    <div class="col-lg-8 col-xl-7">
                        <form id="contactForm" data-sb-form-api-token="API_TOKEN">
                            <!-- Name input-->
                            <div class="form-floating mb-3">
                                <input class="form-control" id="name" type="text" placeholder="Enter your name..."
                                    data-sb-validations="required" />
                                <label for="name">Full name</label>
                                <div class="invalid-feedback" data-sb-feedback="name:required">A name is required.</div>
                            </div>
                            <!-- Email address input-->
                            <div class="form-floating mb-3">
                                <input class="form-control" id="email" type="email" placeholder="name@example.com"
                                    data-sb-validations="required,email" />
                                <label for="email">Email address</label>
                                <div class="invalid-feedback" data-sb-feedback="email:required">An email is required.</div>
                                <div class="invalid-feedback" data-sb-feedback="email:email">Email is not valid.</div>
                            </div>
                            <!-- Phone number input-->
                            <div class="form-floating mb-3">
                                <input class="form-control" id="phone" type="tel" placeholder="(123) 456-7890"
                                    data-sb-validations="required" />
                                <label for="phone">Phone number</label>
                                <div class="invalid-feedback" data-sb-feedback="phone:required">A phone number is required.
                                </div>
                            </div>
                            <!-- Message input-->
                            <div class="form-floating mb-3">
                                <textarea class="form-control" id="message" type="text"
                                    placeholder="Enter your message here..." style="height: 10rem"
                                    data-sb-validations="required"></textarea>
                                <label for="message">Message</label>
                                <div class="invalid-feedback" data-sb-feedback="message:required">A message is required.
                                </div>
                            </div>
                            <!-- Submit success message-->
                            <!---->
                            <!-- This is what your users will see when the form-->
                            <!-- has successfully submitted-->
                            <div class="d-none" id="submitSuccessMessage">
                                <div class="text-center mb-3">
                                    <div class="fw-bolder">Form submission successful!</div>
                                    To activate this form, sign up at
                                    <br />
                                    <a href="https://startbootstrap.com/solution/contact-forms">https://startbootstrap.com/solution/contact-forms</a>
                                </div>
                            </div>
                            <!-- Submit error message-->
                            <!---->
                            <!-- This is what your users will see when there is-->
                            <!-- an error submitting the form-->
                            <div class="d-none" id="submitErrorMessage">
                                <div class="text-center text-danger mb-3">Error sending message!</div>
                            </div>
                            <!-- Submit Button-->
                            <button class="btn btn-primary btn-xl disabled" id="submitButton" type="submit">Send</button>
                        </form>
                    </div>
                </div>
            </div>
        </section>
        <!-- Footer-->
        <Basic_footer />
        <!-- Copyright Section-->
        <div class="copyright py-4 text-center text-white">
            <div class="container"><small>Copyright &copy; Your Website 2022</small></div>
        </div>
    </div>
</template>

<script>
import Main_header from './components/main-header'
import Main_nav from './components/main_nav'
import Basic_footer from './components/basic_footer.vue'
import axios from 'axios'
import MyModal from './components/modal/basic_modal.vue'

export default {
    components: {
        Main_header,
        Main_nav,
        Basic_footer,
        MyModal
    },
    data() {
        return {
            itemData: [],
            showModal: false,
            showMenu: ""
        }
    },
    methods: {
        ItemBinding() {
            axios.get('/api/getMenus', {
                headers: {
                    Accept: 'application/json'
                }
            }).then(
                response => {
                    this.itemData = response.data.map(item => {
                        return {
                            ...item,
                            src: require('./assets/img/portfolio/' + item.menuName + '.png')
                        }
                    });
                }
            )
        },
        showBasicModal(item) {
            if(item.menuName != ""){
                this.showMenu = item.menuName;
                this.showModal = true;
            }else{
            this.showMenu = "";
            this.showModal = false;
        }
        },
        closeBasicModal() {
            this.showModal = false;
        }
    },
    created() {
        this.ItemBinding();
    }
}

</script>
<style>
@import "./css/styles.css";

/* 모달 페이드 */
.fade-enter-from {
  transform: translateY(-150px);
}
.fade-enter-active {
  transition: all 0.3s;
}
.fade-enter-to {
  transform: translateY(0px);
}

.fade-leave-from {
    opacity: 1;
}

.fade-leave-active {
    transition: all 0.4s;
}

.fade-leave-to {
    opacity: 0;
}
</style>