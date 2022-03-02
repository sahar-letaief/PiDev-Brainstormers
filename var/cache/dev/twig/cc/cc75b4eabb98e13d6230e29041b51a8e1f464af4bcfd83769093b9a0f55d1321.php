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

/* user/index.html.twig */
class __TwigTemplate_abee4f93f5983c7b554e06c3545d7ecff68411ba43743479e11b9d04681b99a8 extends Template
{
    private $source;
    private $macros = [];

    public function __construct(Environment $env)
    {
        parent::__construct($env);

        $this->source = $this->getSourceContext();

        $this->blocks = [
            'stylesheets' => [$this, 'block_stylesheets'],
            'body' => [$this, 'block_body'],
        ];
    }

    protected function doGetParent(array $context)
    {
        // line 1
        return "baseBack.html.twig";
    }

    protected function doDisplay(array $context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "user/index.html.twig"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "user/index.html.twig"));

        $this->parent = $this->loadTemplate("baseBack.html.twig", "user/index.html.twig", 1);
        $this->parent->display($context, array_merge($this->blocks, $blocks));
        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

    }

    // line 3
    public function block_stylesheets($context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "stylesheets"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "stylesheets"));

        // line 4
        echo "    <!-- Required meta tags -->
    <meta charset=\"utf-8\">
    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
    <title>GAMEX</title>
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
    <link rel=\"stylesheet\" href=\"";
        // line 13
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/vendors/jvectormap/jquery-jvectormap.css"), "html", null, true);
        echo "\">
    <link rel=\"stylesheet\" href=\"";
        // line 14
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/vendors/flag-icon-css/css/flag-icon.min.css"), "html", null, true);
        echo "\">
    <link rel=\"stylesheet\" href=\"";
        // line 15
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/vendors/owl-carousel-2/owl.carousel.min.css"), "html", null, true);
        echo "\">
    <link rel=\"stylesheet\" href=\"";
        // line 16
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/vendors/owl-carousel-2/owl.theme.default.min.css"), "html", null, true);
        echo "\">
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <!-- endinject -->
    <!-- Layout styles -->
    <link rel=\"stylesheet\" href=\"";
        // line 21
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/css/style.css"), "html", null, true);
        echo "\">
    <!-- End layout styles -->
    <link rel=\"shortcut icon\" href=\"";
        // line 23
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("Back/assets/images/favicon.png"), "html", null, true);
        echo "\" />

    <style>

        .pagination{
            justify-content: center;
        }
        .current{
            margin: 0px 5px 0px 5px;
            border-radius: 50%;
            width: 2%;
            text-align: center;
            border: solid #0090e7;
        }

        .page{
            margin: 0px 5px 0px 5px;
            border-radius: 50%;
            width: 2%;
            text-align: center;
            border: solid #0090e7;
        }

        .page a{
            color: white;
        }

        .previous a{
            color: white;
            margin-left: 5px;
            border-bottom: 1px solid #00d25b;
        }
        .next a{
            color: white;
            margin-right: 5px;
            border-bottom: 1px solid #00d25b;
        }

        .first a{
            color: #00d25b;
            margin-left: 5px;
            border-bottom: 1px solid #00d25b;
        }
        .last a{
            color: #00d25b;
            border-bottom: 1px solid #00d25b;
        }
    </style>

    <style>
        .form-check .form-check-label input[type=\"radio\"] + .input-helper:before {
            border: solid #00d25b;

        }

        .form-check .form-check-label input[type=\"radio\"]:checked + .input-helper:before {
            background-color: #00d25b;
        }

        .table thead th, .jsgrid .jsgrid-table thead th {
            color: #0090e7;
        }
        
        .table, .jsgrid .jsgrid-table {
            color: #ffffff;
        }
    </style>
";
        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

    }

    // line 92
    public function block_body($context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "body"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "body"));

        // line 93
        echo "    <div class=\"main-panel\">
        <div class=\"content-wrapper\">
            <div class=\"page-header\">
                <h3 class=\"page-title\">ADMIN INTERFACE </h3>

            </div>
            <div class=\"row\">
                <div class=\"col-lg-12 grid-margin stretch-card\">
                    <div class=\"card\">
                        <div class=\"card-body\">
                            <div style=\"display: flex\">
                                <div class=\"col-md-7\">
                                    <h4 class=\"card-title\">USERS</h4>
                                </div>
                                <form method=\"post\" class=\"forms-sample\" style=\"margin-left: 29px\" >
                                    <div class=\"form-group col-md-4\" style=\"display: flex; width: 100%!important; margin: 0px!important;\">

                                        <div class=\"form-check\">
                                            <label class=\"form-check-label\" style=\"width: 55px;margin-left: -2px;margin-right: 10px;color: white;\">
                                                <input style=\"border: solid #00d25b;\" type=\"radio\" class=\"form-check-input\" name=\"optionsRadios\" id=\"optionsRadios1\" value=\"email\"> Email </label>
                                        </div>
                                        <div class=\"form-check\">
                                            <label class=\"form-check-label\" style=\"width: 78px;margin-left: -2px;margin-right: 10px;color: white;\">
                                                <input type=\"radio\" class=\"form-check-input\" name=\"optionsRadios\" id=\"optionsRadios2\" value=\"firstname\" > Full name </label>
                                        </div>
                                        <div class=\"form-check\">
                                            <label class=\"form-check-label\" style=\"width: 79px;margin-left: -2px;margin-right: 10px;color: white;\">
                                                <input type=\"radio\" class=\"form-check-input\" name=\"optionsRadios\" id=\"optionsRadios3\" value=\"usertag\" > Username </label>
                                        </div>
                                        <div class=\"form-check\">
                                            <label class=\"form-check-label\" style=\"width: 118px;margin-left: -2px;margin-right: 10px;color: white;\">
                                                <input type=\"radio\" class=\"form-check-input\" name=\"optionsRadios\" id=\"optionsRadios4\" value=\"phonenumber\"  > Phone Number </label>
                                        </div>
                                        <button type=\"Submit\" class=\"btn btn-success btn-fw\">Sort</button>
                                    </div>
                                </form>

                            </div>
                            <p class=\"card-description\">only someone with administrative priviliges has access to this page</code>
                            </p>
                            <ul class=\"navbar-nav w-100\">
                                <li class=\"nav-item w-100\">
                                    <form name=\"Search-method\" id=\"Search-method\"method=\"post\" class=\"forms-sample\" style=\"display: flex\">
                                        <div class=\"form-group col-md-3\">
                                            <label style=\"margin-top: 11px;margin-left: 10px;margin-right: 14px;border-bottom: 6px solid #0090e7;padding-bottom: 7px;border-bottom-style: dotted;\">Search Options</label>
                                            <select name=\"optionsearch\" class=\"js-example-basic-single\" style=\"width: 200px;height: 38px; color: white; background-color: #191c24; border-radius: 4px;text-align: center;border: 2px solid #0090e7;margin-right: 15px;\">
                                                <option value=\"email\">Email</option>
                                                <option value=\"firstname\">First Name</option>
                                                <option value=\"lastname\">Last Name</option>
                                                <option value=\"usertag\">UserName</option>
                                                <option value=\"phonenumber\">Phone Number</option>
                                            </select>
                                        </div>
                                        <div class=\"form-group col-md-9\">
                                            <div class=\"input-group\">
                                                <input name=\"Search\" type=\"text\" class=\"form-control\" placeholder=\"Search Users\" aria-label=\"Recipient's username\" aria-describedby=\"basic-addon2\">
                                                <div class=\"input-group-append\">
                                                    <button class=\"btn btn-sm btn-primary\" type=\"Submit\">Search</button>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </li>
                            </ul>
                            ";
        // line 157
        if ( !twig_get_attribute($this->env, $this->source, (isset($context["users"]) || array_key_exists("users", $context) ? $context["users"] : (function () { throw new RuntimeError('Variable "users" does not exist.', 157, $this->source); })()), "items", [], "any", false, false, false, 157)) {
            // line 158
            echo "                            <div style=\"display: grid;\">
                                <label style=\"width: 22%;margin: auto;margin-bottom: 13px;margin-top: 10px;border: 2px solid #0090e7;padding: 10px;border-radius: 20px;border-left: 2px solid red;border-right: 2px solid red;text-align: center; font-style: oblique;color: chartreuse;\"> NO USERS FOUND WITH SUCH CRITERIA</label>
                            </div>
                            ";
        } else {
            // line 162
            echo "                            <div class=\"table-responsive\">
                                <table class=\"table\">
                                    <thead>
                                    <tr>
                                        <th>Username</th>
                                        <th>Email</th>
                                        <th>Phone number</th>
                                        <th>Roles</th>
                                        <th>Password</th>
                                        <th>full name</th>
                                        <th>actions</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    ";
            // line 176
            $context['_parent'] = $context;
            $context['_seq'] = twig_ensure_traversable((isset($context["users"]) || array_key_exists("users", $context) ? $context["users"] : (function () { throw new RuntimeError('Variable "users" does not exist.', 176, $this->source); })()));
            foreach ($context['_seq'] as $context["_key"] => $context["user"]) {
                // line 177
                echo "                                        <tr>
                                            <td>";
                // line 178
                echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, $context["user"], "usertag", [], "any", false, false, false, 178), "html", null, true);
                echo "</td>
                                            <td>";
                // line 179
                echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, $context["user"], "username", [], "any", false, false, false, 179), "html", null, true);
                echo "</td>
                                            <td>";
                // line 180
                echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, $context["user"], "phonenumber", [], "any", false, false, false, 180), "html", null, true);
                echo "</td>

                                            <td>
                                                ";
                // line 183
                $context['_parent'] = $context;
                $context['_seq'] = twig_ensure_traversable(twig_get_attribute($this->env, $this->source, $context["user"], "roles", [], "any", false, false, false, 183));
                foreach ($context['_seq'] as $context["_key"] => $context["role"]) {
                    // line 184
                    echo "                                                    ";
                    if ((0 === twig_compare($context["role"], "ROLE_ADMIN"))) {
                        // line 185
                        echo "                                                        <label class=\"badge badge-success\">ADMIN</label>
                                                    ";
                    } elseif ((0 === twig_compare(                    // line 186
$context["role"], "ROLE_PLAYER"))) {
                        // line 187
                        echo "                                                        <label class=\"badge badge-info\">PLAYER</label>
                                                    ";
                    } elseif ((0 === twig_compare(                    // line 188
$context["role"], "ROLE_USER"))) {
                        // line 189
                        echo "                                                        <label class=\"badge badge-warning\">USER</label>
                                                    ";
                    } elseif ((0 === twig_compare(                    // line 190
$context["role"], "ROLE_PRODUCT"))) {
                        // line 191
                        echo "                                                        <label class=\"badge badge-primary\">Product Manager</label>
                                                    ";
                    } elseif ((0 === twig_compare(                    // line 192
$context["role"], "ROLE_PURCHASE"))) {
                        // line 193
                        echo "                                                        <label class=\"badge badge-primary\">Purchase Manager</label>
                                                    ";
                    } elseif ((0 === twig_compare(                    // line 194
$context["role"], "ROLE_RECLAMATION"))) {
                        // line 195
                        echo "                                                        <label class=\"badge badge-primary\">Reclamation Manager</label>
                                                    ";
                    } elseif ((0 === twig_compare(                    // line 196
$context["role"], "ROLE_EVENT"))) {
                        // line 197
                        echo "                                                        <label class=\"badge badge-primary\">Event Manager</label>
                                                    ";
                    }
                    // line 199
                    echo "                                                ";
                }
                $_parent = $context['_parent'];
                unset($context['_seq'], $context['_iterated'], $context['_key'], $context['role'], $context['_parent'], $context['loop']);
                $context = array_intersect_key($context, $_parent) + $_parent;
                // line 200
                echo "                                            </td>

                                            <td>Crypted</td>
                                            <td>";
                // line 203
                echo twig_escape_filter($this->env, ((twig_get_attribute($this->env, $this->source, $context["user"], "firstname", [], "any", false, false, false, 203) . " ") . twig_get_attribute($this->env, $this->source, $context["user"], "lastname", [], "any", false, false, false, 203)), "html", null, true);
                echo "</td>

                                            <td>
                                                <a class=\"btn btn-outline-primary btn-fw\" href=\"";
                // line 206
                echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("user_show", ["id" => twig_get_attribute($this->env, $this->source, $context["user"], "id", [], "any", false, false, false, 206)]), "html", null, true);
                echo "\">show</a>
                                                <a class=\"btn btn-outline-primary btn-fw\" href=\"";
                // line 207
                echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("user_edit", ["id" => twig_get_attribute($this->env, $this->source, $context["user"], "id", [], "any", false, false, false, 207)]), "html", null, true);
                echo "\">edit</a>
                                            </td>
                                        </tr>



                                    ";
            }
            $_parent = $context['_parent'];
            unset($context['_seq'], $context['_iterated'], $context['_key'], $context['user'], $context['_parent'], $context['loop']);
            $context = array_intersect_key($context, $_parent) + $_parent;
            // line 214
            echo "
                                    ";
        }
        // line 216
        echo "
                                    </tbody>
                                </table>

                                ";
        // line 220
        echo $this->extensions['Knp\Bundle\PaginatorBundle\Twig\Extension\PaginationExtension']->render($this->env, (isset($context["users"]) || array_key_exists("users", $context) ? $context["users"] : (function () { throw new RuntimeError('Variable "users" does not exist.', 220, $this->source); })()));
        echo "

                                ";
        // line 222
        if ((isset($context["back"]) || array_key_exists("back", $context) ? $context["back"] : (function () { throw new RuntimeError('Variable "back" does not exist.', 222, $this->source); })())) {
            // line 223
            echo "                                    <div style=\"display: grid; margin-top: 20px;\">
                                        <a class=\"btn btn-outline-primary btn-fw\" href=\"";
            // line 224
            echo $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("user_index");
            echo "\">Back</a>
                                    </div>
                                ";
        }
        // line 227
        echo "                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
";
        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

    }

    public function getTemplateName()
    {
        return "user/index.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  411 => 227,  405 => 224,  402 => 223,  400 => 222,  395 => 220,  389 => 216,  385 => 214,  372 => 207,  368 => 206,  362 => 203,  357 => 200,  351 => 199,  347 => 197,  345 => 196,  342 => 195,  340 => 194,  337 => 193,  335 => 192,  332 => 191,  330 => 190,  327 => 189,  325 => 188,  322 => 187,  320 => 186,  317 => 185,  314 => 184,  310 => 183,  304 => 180,  300 => 179,  296 => 178,  293 => 177,  289 => 176,  273 => 162,  267 => 158,  265 => 157,  199 => 93,  189 => 92,  111 => 23,  106 => 21,  98 => 16,  94 => 15,  90 => 14,  86 => 13,  80 => 10,  76 => 9,  69 => 4,  59 => 3,  36 => 1,);
    }

    public function getSourceContext()
    {
        return new Source("{% extends 'baseBack.html.twig' %}

{% block stylesheets %}
    <!-- Required meta tags -->
    <meta charset=\"utf-8\">
    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
    <title>GAMEX</title>
    <!-- plugins:css -->
    <link rel=\"stylesheet\" href=\"{{ asset('Back/assets/vendors/mdi/css/materialdesignicons.min.css') }}\">
    <link rel=\"stylesheet\" href=\"{{ asset('Back/assets/vendors/css/vendor.bundle.base.css') }}\">
    <!-- endinject -->
    <!-- Plugin css for this page -->
    <link rel=\"stylesheet\" href=\"{{ asset('Back/assets/vendors/jvectormap/jquery-jvectormap.css') }}\">
    <link rel=\"stylesheet\" href=\"{{ asset('Back/assets/vendors/flag-icon-css/css/flag-icon.min.css') }}\">
    <link rel=\"stylesheet\" href=\"{{ asset('Back/assets/vendors/owl-carousel-2/owl.carousel.min.css') }}\">
    <link rel=\"stylesheet\" href=\"{{ asset('Back/assets/vendors/owl-carousel-2/owl.theme.default.min.css') }}\">
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <!-- endinject -->
    <!-- Layout styles -->
    <link rel=\"stylesheet\" href=\"{{ asset('Back/assets/css/style.css') }}\">
    <!-- End layout styles -->
    <link rel=\"shortcut icon\" href=\"{{ asset('Back/assets/images/favicon.png') }}\" />

    <style>

        .pagination{
            justify-content: center;
        }
        .current{
            margin: 0px 5px 0px 5px;
            border-radius: 50%;
            width: 2%;
            text-align: center;
            border: solid #0090e7;
        }

        .page{
            margin: 0px 5px 0px 5px;
            border-radius: 50%;
            width: 2%;
            text-align: center;
            border: solid #0090e7;
        }

        .page a{
            color: white;
        }

        .previous a{
            color: white;
            margin-left: 5px;
            border-bottom: 1px solid #00d25b;
        }
        .next a{
            color: white;
            margin-right: 5px;
            border-bottom: 1px solid #00d25b;
        }

        .first a{
            color: #00d25b;
            margin-left: 5px;
            border-bottom: 1px solid #00d25b;
        }
        .last a{
            color: #00d25b;
            border-bottom: 1px solid #00d25b;
        }
    </style>

    <style>
        .form-check .form-check-label input[type=\"radio\"] + .input-helper:before {
            border: solid #00d25b;

        }

        .form-check .form-check-label input[type=\"radio\"]:checked + .input-helper:before {
            background-color: #00d25b;
        }

        .table thead th, .jsgrid .jsgrid-table thead th {
            color: #0090e7;
        }
        
        .table, .jsgrid .jsgrid-table {
            color: #ffffff;
        }
    </style>
{% endblock %}

{% block body %}
    <div class=\"main-panel\">
        <div class=\"content-wrapper\">
            <div class=\"page-header\">
                <h3 class=\"page-title\">ADMIN INTERFACE </h3>

            </div>
            <div class=\"row\">
                <div class=\"col-lg-12 grid-margin stretch-card\">
                    <div class=\"card\">
                        <div class=\"card-body\">
                            <div style=\"display: flex\">
                                <div class=\"col-md-7\">
                                    <h4 class=\"card-title\">USERS</h4>
                                </div>
                                <form method=\"post\" class=\"forms-sample\" style=\"margin-left: 29px\" >
                                    <div class=\"form-group col-md-4\" style=\"display: flex; width: 100%!important; margin: 0px!important;\">

                                        <div class=\"form-check\">
                                            <label class=\"form-check-label\" style=\"width: 55px;margin-left: -2px;margin-right: 10px;color: white;\">
                                                <input style=\"border: solid #00d25b;\" type=\"radio\" class=\"form-check-input\" name=\"optionsRadios\" id=\"optionsRadios1\" value=\"email\"> Email </label>
                                        </div>
                                        <div class=\"form-check\">
                                            <label class=\"form-check-label\" style=\"width: 78px;margin-left: -2px;margin-right: 10px;color: white;\">
                                                <input type=\"radio\" class=\"form-check-input\" name=\"optionsRadios\" id=\"optionsRadios2\" value=\"firstname\" > Full name </label>
                                        </div>
                                        <div class=\"form-check\">
                                            <label class=\"form-check-label\" style=\"width: 79px;margin-left: -2px;margin-right: 10px;color: white;\">
                                                <input type=\"radio\" class=\"form-check-input\" name=\"optionsRadios\" id=\"optionsRadios3\" value=\"usertag\" > Username </label>
                                        </div>
                                        <div class=\"form-check\">
                                            <label class=\"form-check-label\" style=\"width: 118px;margin-left: -2px;margin-right: 10px;color: white;\">
                                                <input type=\"radio\" class=\"form-check-input\" name=\"optionsRadios\" id=\"optionsRadios4\" value=\"phonenumber\"  > Phone Number </label>
                                        </div>
                                        <button type=\"Submit\" class=\"btn btn-success btn-fw\">Sort</button>
                                    </div>
                                </form>

                            </div>
                            <p class=\"card-description\">only someone with administrative priviliges has access to this page</code>
                            </p>
                            <ul class=\"navbar-nav w-100\">
                                <li class=\"nav-item w-100\">
                                    <form name=\"Search-method\" id=\"Search-method\"method=\"post\" class=\"forms-sample\" style=\"display: flex\">
                                        <div class=\"form-group col-md-3\">
                                            <label style=\"margin-top: 11px;margin-left: 10px;margin-right: 14px;border-bottom: 6px solid #0090e7;padding-bottom: 7px;border-bottom-style: dotted;\">Search Options</label>
                                            <select name=\"optionsearch\" class=\"js-example-basic-single\" style=\"width: 200px;height: 38px; color: white; background-color: #191c24; border-radius: 4px;text-align: center;border: 2px solid #0090e7;margin-right: 15px;\">
                                                <option value=\"email\">Email</option>
                                                <option value=\"firstname\">First Name</option>
                                                <option value=\"lastname\">Last Name</option>
                                                <option value=\"usertag\">UserName</option>
                                                <option value=\"phonenumber\">Phone Number</option>
                                            </select>
                                        </div>
                                        <div class=\"form-group col-md-9\">
                                            <div class=\"input-group\">
                                                <input name=\"Search\" type=\"text\" class=\"form-control\" placeholder=\"Search Users\" aria-label=\"Recipient's username\" aria-describedby=\"basic-addon2\">
                                                <div class=\"input-group-append\">
                                                    <button class=\"btn btn-sm btn-primary\" type=\"Submit\">Search</button>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </li>
                            </ul>
                            {% if not (users.items) %}
                            <div style=\"display: grid;\">
                                <label style=\"width: 22%;margin: auto;margin-bottom: 13px;margin-top: 10px;border: 2px solid #0090e7;padding: 10px;border-radius: 20px;border-left: 2px solid red;border-right: 2px solid red;text-align: center; font-style: oblique;color: chartreuse;\"> NO USERS FOUND WITH SUCH CRITERIA</label>
                            </div>
                            {% else %}
                            <div class=\"table-responsive\">
                                <table class=\"table\">
                                    <thead>
                                    <tr>
                                        <th>Username</th>
                                        <th>Email</th>
                                        <th>Phone number</th>
                                        <th>Roles</th>
                                        <th>Password</th>
                                        <th>full name</th>
                                        <th>actions</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    {% for user in users %}
                                        <tr>
                                            <td>{{ user.usertag }}</td>
                                            <td>{{ user.username }}</td>
                                            <td>{{ user.phonenumber }}</td>

                                            <td>
                                                {% for role in user.roles %}
                                                    {% if role == 'ROLE_ADMIN' %}
                                                        <label class=\"badge badge-success\">ADMIN</label>
                                                    {% elseif role == 'ROLE_PLAYER'%}
                                                        <label class=\"badge badge-info\">PLAYER</label>
                                                    {% elseif role == 'ROLE_USER' %}
                                                        <label class=\"badge badge-warning\">USER</label>
                                                    {% elseif role == 'ROLE_PRODUCT' %}
                                                        <label class=\"badge badge-primary\">Product Manager</label>
                                                    {% elseif role == 'ROLE_PURCHASE' %}
                                                        <label class=\"badge badge-primary\">Purchase Manager</label>
                                                    {% elseif role == 'ROLE_RECLAMATION' %}
                                                        <label class=\"badge badge-primary\">Reclamation Manager</label>
                                                    {% elseif role == 'ROLE_EVENT' %}
                                                        <label class=\"badge badge-primary\">Event Manager</label>
                                                    {% endif %}
                                                {% endfor %}
                                            </td>

                                            <td>Crypted</td>
                                            <td>{{ user.firstname ~ \" \" ~ user.lastname}}</td>

                                            <td>
                                                <a class=\"btn btn-outline-primary btn-fw\" href=\"{{ path('user_show', {'id': user.id}) }}\">show</a>
                                                <a class=\"btn btn-outline-primary btn-fw\" href=\"{{ path('user_edit', {'id': user.id}) }}\">edit</a>
                                            </td>
                                        </tr>



                                    {% endfor %}

                                    {% endif %}

                                    </tbody>
                                </table>

                                {{ knp_pagination_render(users) }}

                                {% if (back) %}
                                    <div style=\"display: grid; margin-top: 20px;\">
                                        <a class=\"btn btn-outline-primary btn-fw\" href=\"{{ path('user_index') }}\">Back</a>
                                    </div>
                                {% endif %}
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
{% endblock %}
", "user/index.html.twig", "C:\\Users\\Yassine\\Desktop\\git-login-symfony\\templates\\user\\index.html.twig");
    }
}
