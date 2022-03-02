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

/* baseFront.html.twig */
class __TwigTemplate_d2271a55804a6c5fbf8ecc9df04d21dff52aa4e807a2942051d6f4f03f6778af extends Template
{
    private $source;
    private $macros = [];

    public function __construct(Environment $env)
    {
        parent::__construct($env);

        $this->source = $this->getSourceContext();

        $this->parent = false;

        $this->blocks = [
            'stylesheets' => [$this, 'block_stylesheets'],
            'nav' => [$this, 'block_nav'],
            'body' => [$this, 'block_body'],
            'footer' => [$this, 'block_footer'],
            'javascripts' => [$this, 'block_javascripts'],
        ];
    }

    protected function doDisplay(array $context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "baseFront.html.twig"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "baseFront.html.twig"));

        // line 1
        echo "<!DOCTYPE html>
<html>
<head>

    ";
        // line 5
        $this->displayBlock('stylesheets', $context, $blocks);
        // line 28
        echo "
</head>
<body>
<!-- Page Preloder -->
<div id=\"preloder\">
        <div class=\"loader\"></div>
</div>
        ";
        // line 35
        $this->displayBlock('nav', $context, $blocks);
        // line 80
        echo "
        ";
        // line 81
        $this->displayBlock('body', $context, $blocks);
        // line 83
        echo "
";
        // line 84
        $this->displayBlock('footer', $context, $blocks);
        // line 118
        echo "<!-- container-scroller -->
</body>

";
        // line 121
        $this->displayBlock('javascripts', $context, $blocks);
        // line 132
        echo "

</html>
";
        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

    }

    // line 5
    public function block_stylesheets($context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "stylesheets"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "stylesheets"));

        // line 6
        echo "        <meta charset=\"UTF-8\">
        <meta name=\"description\" content=\"Anime Template\">
        <meta name=\"keywords\" content=\"Anime, unica, creative, html\">
        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">
        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">
        <title>Anime | Template</title>

        <!-- Google Font -->
        <link href=\"https://fonts.googleapis.com/css2?family=Oswald:wght@300;400;500;600;700&display=swap\" rel=\"stylesheet\">
        <link href=\"https://fonts.googleapis.com/css2?family=Mulish:wght@300;400;500;600;700;800;900&display=swap\"
              rel=\"stylesheet\">

        <!-- Css Styles -->
        <link rel=\"stylesheet\" href=\"";
        // line 19
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Front/css/bootstrap.min.css"), "html", null, true);
        echo "\" type=\"text/css\">
        <link rel=\"stylesheet\" href=\"";
        // line 20
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Front/css/font-awesome.min.css"), "html", null, true);
        echo "\" type=\"text/css\">
        <link rel=\"stylesheet\" href=\"";
        // line 21
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Front/css/elegant-icons.css"), "html", null, true);
        echo "\" type=\"text/css\">
        <link rel=\"stylesheet\" href=\"";
        // line 22
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Front/css/plyr.css"), "html", null, true);
        echo "\" type=\"text/css\">
        <link rel=\"stylesheet\" href=\"";
        // line 23
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Front/css/nice-select.css"), "html", null, true);
        echo "\" type=\"text/css\">
        <link rel=\"stylesheet\" href=\"";
        // line 24
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Front/css/owl.carousel.min.css"), "html", null, true);
        echo "\" type=\"text/css\">
        <link rel=\"stylesheet\" href=\"";
        // line 25
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Front/css/slicknav.min.css"), "html", null, true);
        echo "\" type=\"text/css\">
        <link rel=\"stylesheet\" href=\"";
        // line 26
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Front/css/style.css"), "html", null, true);
        echo "\" type=\"text/css\">
    ";
        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

    }

    // line 35
    public function block_nav($context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "nav"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "nav"));

        // line 36
        echo "                <!-- Header Section Begin -->
                <header class=\"header\">
                        <div class=\"container\">
                                <div class=\"row\">
                                        <div class=\"col-lg-2\">
                                                <div class=\"header__logo\">
                                                        <a href=\"./index.html\">
                                                                <img src=\"img/logo.png\" alt=\"\">
                                                        </a>
                                                </div>
                                        </div>
                                        <div class=\"col-lg-8\">
                                                <div class=\"header__nav\">
                                                        <nav class=\"header__menu mobile-menu\">
                                                                <ul>
                                                                        <li class=\"active\"><a href=\"./index.html\">Homepage</a></li>
                                                                        <li><a href=\"./categories.html\">Categories <span class=\"arrow_carrot-down\"></span></a>
                                                                                <ul class=\"dropdown\">
                                                                                        <li><a href=\"./categories.html\">Categories</a></li>
                                                                                        <li><a href=\"./anime-details.html\">Anime Details</a></li>
                                                                                        <li><a href=\"./anime-watching.html\">Anime Watching</a></li>
                                                                                        <li><a href=\"./blog-details.html\">Blog Details</a></li>
                                                                                        <li><a href=\"./signup.html\">Sign Up</a></li>
                                                                                        <li><a href=\"./login.html\">Login</a></li>
                                                                                </ul>
                                                                        </li>
                                                                        <li><a href=\"./blog.html\">Our Blog</a></li>
                                                                        <li><a href=\"#\">Contacts</a></li>
                                                                </ul>
                                                        </nav>
                                                </div>
                                        </div>
                                        <div class=\"col-lg-2\">
                                                <div class=\"header__right\">
                                                        <a href=\"#\" class=\"search-switch\"><span class=\"icon_search\"></span></a>
                                                        <a href=\"./login.html\"><span class=\"icon_profile\"></span></a>
                                                </div>
                                        </div>
                                </div>
                                <div id=\"mobile-menu-wrap\"></div>
                        </div>
                </header>
                <!-- Header End -->
        ";
        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

    }

    // line 81
    public function block_body($context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "body"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "body"));

        // line 82
        echo "        ";
        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

    }

    // line 84
    public function block_footer($context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "footer"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "footer"));

        // line 85
        echo "        <!-- Footer Section Begin -->
        <footer class=\"footer\">
                <div class=\"page-up\">
                        <a href=\"#\" id=\"scrollToTopButton\"><span class=\"arrow_carrot-up\"></span></a>
                </div>
                <div class=\"container\">
                        <div class=\"row\">
                                <div class=\"col-lg-3\">
                                        <div class=\"footer__logo\">
                                                <a href=\"./index.html\"><img src=\"img/logo.png\" alt=\"\"></a>
                                        </div>
                                </div>
                                <div class=\"col-lg-6\">
                                        <div class=\"footer__nav\">
                                                <ul>
                                                        <li class=\"active\"><a href=\"./index.html\">Homepage</a></li>
                                                        <li><a href=\"./categories.html\">Categories</a></li>
                                                        <li><a href=\"./blog.html\">Our Blog</a></li>
                                                        <li><a href=\"#\">Contacts</a></li>
                                                </ul>
                                        </div>
                                </div>
                                <div class=\"col-lg-3\">
                                        <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                                Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class=\"fa fa-heart\" aria-hidden=\"true\"></i> by <a href=\"https://colorlib.com\" target=\"_blank\">Colorlib</a>
                                                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>

                                </div>
                        </div>
                </div>
        </footer>
        <!-- Footer Section End -->
";
        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

    }

    // line 121
    public function block_javascripts($context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "javascripts"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "javascripts"));

        // line 122
        echo "    <script src=\"";
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/js/dashboard.js"), "html", null, true);
        echo "\"></script>
        <script src=\"";
        // line 123
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Front/js/jquery-3.3.1.min.js"), "html", null, true);
        echo "\"></script>
        <script src=\"";
        // line 124
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Front/js/bootstrap.min.js"), "html", null, true);
        echo "\"></script>
        <script src=\"";
        // line 125
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Front/js/player.js"), "html", null, true);
        echo "\"></script>
        <script src=\"";
        // line 126
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Front/js/jquery.nice-select.min.js"), "html", null, true);
        echo "\"></script>
        <script src=\"";
        // line 127
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Front/js/mixitup.min.js"), "html", null, true);
        echo "\"></script>
        <script src=\"";
        // line 128
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Front/js/jquery.slicknav.js"), "html", null, true);
        echo "\"></script>
        <script src=\"";
        // line 129
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Front/js/owl.carousel.min.js"), "html", null, true);
        echo "\"></script>
        <script src=\"";
        // line 130
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Front/js/main.js"), "html", null, true);
        echo "\"></script>
";
        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

    }

    public function getTemplateName()
    {
        return "baseFront.html.twig";
    }

    public function getDebugInfo()
    {
        return array (  340 => 130,  336 => 129,  332 => 128,  328 => 127,  324 => 126,  320 => 125,  316 => 124,  312 => 123,  307 => 122,  297 => 121,  255 => 85,  245 => 84,  235 => 82,  225 => 81,  172 => 36,  162 => 35,  150 => 26,  146 => 25,  142 => 24,  138 => 23,  134 => 22,  130 => 21,  126 => 20,  122 => 19,  107 => 6,  97 => 5,  84 => 132,  82 => 121,  77 => 118,  75 => 84,  72 => 83,  70 => 81,  67 => 80,  65 => 35,  56 => 28,  54 => 5,  48 => 1,);
    }

    public function getSourceContext()
    {
        return new Source("<!DOCTYPE html>
<html>
<head>

    {% block stylesheets %}
        <meta charset=\"UTF-8\">
        <meta name=\"description\" content=\"Anime Template\">
        <meta name=\"keywords\" content=\"Anime, unica, creative, html\">
        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">
        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">
        <title>Anime | Template</title>

        <!-- Google Font -->
        <link href=\"https://fonts.googleapis.com/css2?family=Oswald:wght@300;400;500;600;700&display=swap\" rel=\"stylesheet\">
        <link href=\"https://fonts.googleapis.com/css2?family=Mulish:wght@300;400;500;600;700;800;900&display=swap\"
              rel=\"stylesheet\">

        <!-- Css Styles -->
        <link rel=\"stylesheet\" href=\"{{ asset('Front/css/bootstrap.min.css') }}\" type=\"text/css\">
        <link rel=\"stylesheet\" href=\"{{ asset('Front/css/font-awesome.min.css') }}\" type=\"text/css\">
        <link rel=\"stylesheet\" href=\"{{ asset('Front/css/elegant-icons.css') }}\" type=\"text/css\">
        <link rel=\"stylesheet\" href=\"{{ asset('Front/css/plyr.css') }}\" type=\"text/css\">
        <link rel=\"stylesheet\" href=\"{{ asset('Front/css/nice-select.css') }}\" type=\"text/css\">
        <link rel=\"stylesheet\" href=\"{{ asset('Front/css/owl.carousel.min.css') }}\" type=\"text/css\">
        <link rel=\"stylesheet\" href=\"{{ asset('Front/css/slicknav.min.css') }}\" type=\"text/css\">
        <link rel=\"stylesheet\" href=\"{{ asset('Front/css/style.css') }}\" type=\"text/css\">
    {% endblock %}

</head>
<body>
<!-- Page Preloder -->
<div id=\"preloder\">
        <div class=\"loader\"></div>
</div>
        {% block nav %}
                <!-- Header Section Begin -->
                <header class=\"header\">
                        <div class=\"container\">
                                <div class=\"row\">
                                        <div class=\"col-lg-2\">
                                                <div class=\"header__logo\">
                                                        <a href=\"./index.html\">
                                                                <img src=\"img/logo.png\" alt=\"\">
                                                        </a>
                                                </div>
                                        </div>
                                        <div class=\"col-lg-8\">
                                                <div class=\"header__nav\">
                                                        <nav class=\"header__menu mobile-menu\">
                                                                <ul>
                                                                        <li class=\"active\"><a href=\"./index.html\">Homepage</a></li>
                                                                        <li><a href=\"./categories.html\">Categories <span class=\"arrow_carrot-down\"></span></a>
                                                                                <ul class=\"dropdown\">
                                                                                        <li><a href=\"./categories.html\">Categories</a></li>
                                                                                        <li><a href=\"./anime-details.html\">Anime Details</a></li>
                                                                                        <li><a href=\"./anime-watching.html\">Anime Watching</a></li>
                                                                                        <li><a href=\"./blog-details.html\">Blog Details</a></li>
                                                                                        <li><a href=\"./signup.html\">Sign Up</a></li>
                                                                                        <li><a href=\"./login.html\">Login</a></li>
                                                                                </ul>
                                                                        </li>
                                                                        <li><a href=\"./blog.html\">Our Blog</a></li>
                                                                        <li><a href=\"#\">Contacts</a></li>
                                                                </ul>
                                                        </nav>
                                                </div>
                                        </div>
                                        <div class=\"col-lg-2\">
                                                <div class=\"header__right\">
                                                        <a href=\"#\" class=\"search-switch\"><span class=\"icon_search\"></span></a>
                                                        <a href=\"./login.html\"><span class=\"icon_profile\"></span></a>
                                                </div>
                                        </div>
                                </div>
                                <div id=\"mobile-menu-wrap\"></div>
                        </div>
                </header>
                <!-- Header End -->
        {% endblock %}

        {% block body %}
        {% endblock %}

{% block footer %}
        <!-- Footer Section Begin -->
        <footer class=\"footer\">
                <div class=\"page-up\">
                        <a href=\"#\" id=\"scrollToTopButton\"><span class=\"arrow_carrot-up\"></span></a>
                </div>
                <div class=\"container\">
                        <div class=\"row\">
                                <div class=\"col-lg-3\">
                                        <div class=\"footer__logo\">
                                                <a href=\"./index.html\"><img src=\"img/logo.png\" alt=\"\"></a>
                                        </div>
                                </div>
                                <div class=\"col-lg-6\">
                                        <div class=\"footer__nav\">
                                                <ul>
                                                        <li class=\"active\"><a href=\"./index.html\">Homepage</a></li>
                                                        <li><a href=\"./categories.html\">Categories</a></li>
                                                        <li><a href=\"./blog.html\">Our Blog</a></li>
                                                        <li><a href=\"#\">Contacts</a></li>
                                                </ul>
                                        </div>
                                </div>
                                <div class=\"col-lg-3\">
                                        <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                                Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class=\"fa fa-heart\" aria-hidden=\"true\"></i> by <a href=\"https://colorlib.com\" target=\"_blank\">Colorlib</a>
                                                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>

                                </div>
                        </div>
                </div>
        </footer>
        <!-- Footer Section End -->
{% endblock %}
<!-- container-scroller -->
</body>

{% block javascripts %}
    <script src=\"{{ asset('Back/assets/js/dashboard.js') }}\"></script>
        <script src=\"{{ asset('Front/js/jquery-3.3.1.min.js') }}\"></script>
        <script src=\"{{ asset('Front/js/bootstrap.min.js') }}\"></script>
        <script src=\"{{ asset('Front/js/player.js') }}\"></script>
        <script src=\"{{ asset('Front/js/jquery.nice-select.min.js') }}\"></script>
        <script src=\"{{ asset('Front/js/mixitup.min.js') }}\"></script>
        <script src=\"{{ asset('Front/js/jquery.slicknav.js') }}\"></script>
        <script src=\"{{ asset('Front/js/owl.carousel.min.js') }}\"></script>
        <script src=\"{{ asset('Front/js/main.js') }}\"></script>
{% endblock %}


</html>
", "baseFront.html.twig", "C:\\Users\\Yassine\\Desktop\\git-login-symfony\\templates\\baseFront.html.twig");
    }
}
