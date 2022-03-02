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

/* security/reset_password.html.twig */
class __TwigTemplate_3d561ab4c9e92d6c877944565a6e850ea094dbc385620b56bc28493af962027a extends Template
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
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "security/reset_password.html.twig"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "security/reset_password.html.twig"));

        // line 1
        echo "

<!DOCTYPE html>
<html lang=\"en\">
<head>
    <!-- Required meta tags -->
    <meta charset=\"utf-8\">
    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
    <title>Corona Admin</title>
    <!-- plugins:css -->
    <link rel=\"stylesheet\" href=\"";
        // line 11
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/vendors/mdi/css/materialdesignicons.min.css"), "html", null, true);
        echo "\">
    <link rel=\"stylesheet\" href=\"";
        // line 12
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/vendors/css/vendor.bundle.base.css"), "html", null, true);
        echo "\">
    <!-- endinject -->
    <!-- Plugin css for this page -->
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <!-- endinject -->
    <!-- Layout styles -->
    <link rel=\"stylesheet\" href=\"";
        // line 19
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/css/style.css"), "html", null, true);
        echo "\">
    <!-- End layout styles -->
    <link rel=\"shortcut icon\" href=\"";
        // line 21
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
                        <h3 class=\"card-title text-left mb-3\">Login</h3>
                        ";
        // line 36
        if ((isset($context["error"]) || array_key_exists("error", $context) ? $context["error"] : (function () { throw new RuntimeError('Variable "error" does not exist.', 36, $this->source); })())) {
            // line 37
            echo "                            <div class=\"alert alert-danger\">";
            echo twig_escape_filter($this->env, (isset($context["error"]) || array_key_exists("error", $context) ? $context["error"] : (function () { throw new RuntimeError('Variable "error" does not exist.', 37, $this->source); })()), "html", null, true);
            echo "</div>
                        ";
        }
        // line 39
        echo "
                        <form method=\"post\">
                            <div class=\"form-group\">
                                <label>New Password</label>
                                <input class=\"form-control p_input\" type=\"password\" name=\"password\" id=\"pass\">
                            </div>
                            <div class=\"form-group\">
                                <label>New Password</label>
                                <input class=\"form-control p_input\" type=\"password\" name=\"password2\" id=\"pass\">
                            </div>
                            <input type=\"hidden\" name=\"token\" value=\"";
        // line 49
        echo twig_escape_filter($this->env, (isset($context["token"]) || array_key_exists("token", $context) ? $context["token"] : (function () { throw new RuntimeError('Variable "token" does not exist.', 49, $this->source); })()), "html", null, true);
        echo "\">

                            <div class=\"text-center\">
                                <button type=\"submit\" class=\"btn btn-primary btn-block enter-btn\">Submit</button>
                            </div>
                        </form>
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
        // line 66
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/vendors/js/vendor.bundle.base.js"), "html", null, true);
        echo "\"></script>
<!-- endinject -->
<!-- Plugin js for this page -->
<!-- End plugin js for this page -->
<!-- inject:js -->
<script src=\"";
        // line 71
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/js/off-canvas.js"), "html", null, true);
        echo "\"></script>
<script src=\"";
        // line 72
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/js/hoverable-collapse.js"), "html", null, true);
        echo "\"></script>
<script src=\"";
        // line 73
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/js/misc.js"), "html", null, true);
        echo "\"></script>
<script src=\"";
        // line 74
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/js/settings.js"), "html", null, true);
        echo "\"></script>
<script src=\"";
        // line 75
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
        return "security/reset_password.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  156 => 75,  152 => 74,  148 => 73,  144 => 72,  140 => 71,  132 => 66,  112 => 49,  100 => 39,  94 => 37,  92 => 36,  74 => 21,  69 => 19,  59 => 12,  55 => 11,  43 => 1,);
    }

    public function getSourceContext()
    {
        return new Source("

<!DOCTYPE html>
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
                        <h3 class=\"card-title text-left mb-3\">Login</h3>
                        {% if error %}
                            <div class=\"alert alert-danger\">{{ error }}</div>
                        {% endif %}

                        <form method=\"post\">
                            <div class=\"form-group\">
                                <label>New Password</label>
                                <input class=\"form-control p_input\" type=\"password\" name=\"password\" id=\"pass\">
                            </div>
                            <div class=\"form-group\">
                                <label>New Password</label>
                                <input class=\"form-control p_input\" type=\"password\" name=\"password2\" id=\"pass\">
                            </div>
                            <input type=\"hidden\" name=\"token\" value=\"{{ token }}\">

                            <div class=\"text-center\">
                                <button type=\"submit\" class=\"btn btn-primary btn-block enter-btn\">Submit</button>
                            </div>
                        </form>
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

", "security/reset_password.html.twig", "C:\\Users\\Yassine\\Desktop\\git-login-symfony\\templates\\security\\reset_password.html.twig");
    }
}
