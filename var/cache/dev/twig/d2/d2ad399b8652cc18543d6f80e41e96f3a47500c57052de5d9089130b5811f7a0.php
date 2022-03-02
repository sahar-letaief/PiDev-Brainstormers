<?php

use Twig\Environment;
use Twig\Error\LoaderError;
use Twig\Error\RuntimeError;
use Twig\Extension\SandboxExtension;
use Twig\Markup;
use Twig\Sandbox\SecurityError;
use Twig\Sandbox\SecurityNotAllowedTagError;
use Twig\Sandbox\SecurityNotAllowedFilterError;
use Twig\Sandbox\SecurityNotAllowedFunctionError;
use Twig\Source;
use Twig\Template;

/* security/forgotten_password.html.twig */
class __TwigTemplate_f333138bc62490ac1d594ce81274346fbe585a42672c4953319e5bae7a8b6e1e extends Template
{
    private $source;
    private $macros = [];

    public function __construct(Environment $env)
    {
        parent::__construct($env);

        $this->source = $this->getSourceContext();

        $this->parent = false;

        $this->blocks = [
        ];
    }

    protected function doDisplay(array $context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "security/forgotten_password.html.twig"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "security/forgotten_password.html.twig"));

        // line 1
        echo "<!DOCTYPE html>
<html lang=\"en\">
<head>
    <!-- Required meta tags -->
    <meta charset=\"utf-8\">
    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
    <title>Corona Admin</title>
    <!-- plugins:css -->
    <link rel=\"stylesheet\" href=\"";
        // line 9
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/vendors/mdi/css/materialdesignicons.min.css"), "html", null, true);
        echo "\">
    <link rel=\"stylesheet\" href=\"";
        // line 10
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/vendors/css/vendor.bundle.base.css"), "html", null, true);
        echo "\">
    <!-- endinject -->
    <!-- Plugin css for this page -->
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <!-- endinject -->
    <!-- Layout styles -->
    <link rel=\"stylesheet\" href=\"";
        // line 17
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/css/style.css"), "html", null, true);
        echo "\">
    <!-- End layout styles -->
    <link rel=\"shortcut icon\" href=\"";
        // line 19
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/images/favicon.png"), "html", null, true);
        echo "\" />
    <style>
        .card{
            border: 2px solid white;
        }
    </style>
</head>
<body>
<div class=\"container-scroller\">
    <div class=\"container-fluid page-body-wrapper full-page-wrapper\">
        <div class=\"row w-100 m-0\">
            <div class=\"content-wrapper full-page-wrapper d-flex align-items-center auth login-bg\">
                <div class=\"card col-lg-4 mx-auto\">
                    <div class=\"card-body px-5 py-5\">
                        <h3 class=\"card-title text-center mb-3\">Reset Password</h3>


                        ";
        // line 36
        echo         $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->renderBlock((isset($context["emailForm"]) || array_key_exists("emailForm", $context) ? $context["emailForm"] : (function () { throw new RuntimeError('Variable "emailForm" does not exist.', 36, $this->source); })()), 'form_start');
        echo "
                        <div class=\"form-group\">
                            ";
        // line 38
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["emailForm"]) || array_key_exists("emailForm", $context) ? $context["emailForm"] : (function () { throw new RuntimeError('Variable "emailForm" does not exist.', 38, $this->source); })()), "email", [], "any", false, false, false, 38), 'widget', ["attr" => ["class" => "form-control p_input", "placeholder" => "Email"]]);
        echo "
                        </div>
                        <div class=\"text-center\"> ";
        // line 40
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["emailForm"]) || array_key_exists("emailForm", $context) ? $context["emailForm"] : (function () { throw new RuntimeError('Variable "emailForm" does not exist.', 40, $this->source); })()), "submit", [], "any", false, false, false, 40), 'widget', ["attr" => ["class" => " btn btn-lg btn-primary my-4", "placeholder" => "Send Email"]]);
        echo "
                        </div>

                        <p class=\"sign-up\">Don't have an Account?<a href=\"";
        // line 43
        echo $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("app_register");
        echo "\"> Sign Up</a></p>
                        <p class=\"sign-up\">Or Log in !<a href=\"";
        // line 44
        echo $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("app_login");
        echo "\"> Login</a></p>

                        ";
        // line 46
        echo         $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->renderBlock((isset($context["emailForm"]) || array_key_exists("emailForm", $context) ? $context["emailForm"] : (function () { throw new RuntimeError('Variable "emailForm" does not exist.', 46, $this->source); })()), 'form_end');
        echo "

                    </div>


                </div>
                </div>
            </div>
            <!-- content-wrapper ends -->
        </div>
        <!-- row ends -->
    </div>
    <!-- page-body-wrapper ends -->
</div>
<!-- container-scroller -->
<!-- plugins:js -->
<script src=\"";
        // line 62
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/vendors/js/vendor.bundle.base.js"), "html", null, true);
        echo "\"></script>
<!-- endinject -->
<!-- Plugin js for this page -->
<!-- End plugin js for this page -->
<!-- inject:js -->
<script src=\"";
        // line 67
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/js/off-canvas.js"), "html", null, true);
        echo "\"></script>
<script src=\"";
        // line 68
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/js/hoverable-collapse.js"), "html", null, true);
        echo "\"></script>
<script src=\"";
        // line 69
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/js/misc.js"), "html", null, true);
        echo "\"></script>
<script src=\"";
        // line 70
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/js/settings.js"), "html", null, true);
        echo "\"></script>
<script src=\"";
        // line 71
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/js/todolist.js"), "html", null, true);
        echo "\"></script>
<!-- endinject -->
</body>
</html>



";
        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

    }

    public function getTemplateName()
    {
        return "security/forgotten_password.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  160 => 71,  156 => 70,  152 => 69,  148 => 68,  144 => 67,  136 => 62,  117 => 46,  112 => 44,  108 => 43,  102 => 40,  97 => 38,  92 => 36,  72 => 19,  67 => 17,  57 => 10,  53 => 9,  43 => 1,);
    }

    public function getSourceContext()
    {
        return new Source("<!DOCTYPE html>
<html lang=\"en\">
<head>
    <!-- Required meta tags -->
    <meta charset=\"utf-8\">
    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
    <title>Corona Admin</title>
    <!-- plugins:css -->
    <link rel=\"stylesheet\" href=\"{{ asset('Back/assets/vendors/mdi/css/materialdesignicons.min.css') }}\">
    <link rel=\"stylesheet\" href=\"{{ asset('Back/assets/vendors/css/vendor.bundle.base.css') }}\">
    <!-- endinject -->
    <!-- Plugin css for this page -->
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <!-- endinject -->
    <!-- Layout styles -->
    <link rel=\"stylesheet\" href=\"{{ asset('Back/assets/css/style.css') }}\">
    <!-- End layout styles -->
    <link rel=\"shortcut icon\" href=\"{{ asset('Back/assets/images/favicon.png') }}\" />
    <style>
        .card{
            border: 2px solid white;
        }
    </style>
</head>
<body>
<div class=\"container-scroller\">
    <div class=\"container-fluid page-body-wrapper full-page-wrapper\">
        <div class=\"row w-100 m-0\">
            <div class=\"content-wrapper full-page-wrapper d-flex align-items-center auth login-bg\">
                <div class=\"card col-lg-4 mx-auto\">
                    <div class=\"card-body px-5 py-5\">
                        <h3 class=\"card-title text-center mb-3\">Reset Password</h3>


                        {{ form_start(emailForm) }}
                        <div class=\"form-group\">
                            {{ form_widget(emailForm.email  , {'attr' : {'class' : 'form-control p_input' , 'placeholder' : 'Email'}}) }}
                        </div>
                        <div class=\"text-center\"> {{ form_widget(emailForm.submit , {'attr' : {'class' : ' btn btn-lg btn-primary my-4' , 'placeholder' : 'Send Email'}}) }}
                        </div>

                        <p class=\"sign-up\">Don't have an Account?<a href=\"{{ path('app_register') }}\"> Sign Up</a></p>
                        <p class=\"sign-up\">Or Log in !<a href=\"{{ path('app_login') }}\"> Login</a></p>

                        {{ form_end(emailForm) }}

                    </div>


                </div>
                </div>
            </div>
            <!-- content-wrapper ends -->
        </div>
        <!-- row ends -->
    </div>
    <!-- page-body-wrapper ends -->
</div>
<!-- container-scroller -->
<!-- plugins:js -->
<script src=\"{{ asset('Back/assets/vendors/js/vendor.bundle.base.js') }}\"></script>
<!-- endinject -->
<!-- Plugin js for this page -->
<!-- End plugin js for this page -->
<!-- inject:js -->
<script src=\"{{ asset('Back/assets/js/off-canvas.js') }}\"></script>
<script src=\"{{ asset('Back/assets/js/hoverable-collapse.js') }}\"></script>
<script src=\"{{ asset('Back/assets/js/misc.js') }}\"></script>
<script src=\"{{ asset('Back/assets/js/settings.js') }}\"></script>
<script src=\"{{ asset('Back/assets/js/todolist.js') }}\"></script>
<!-- endinject -->
</body>
</html>



", "security/forgotten_password.html.twig", "C:\\Users\\Yassine\\Desktop\\git-login-symfony\\templates\\security\\forgotten_password.html.twig");
    }
}
