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

/* user/show.html.twig */
class __TwigTemplate_639bc3f91677945c67c5531d41cf117b0660a8e3ffc3d02dbac9f31e0248d484 extends Template
{
    private $source;
    private $macros = [];

    public function __construct(Environment $env)
    {
        parent::__construct($env);

        $this->source = $this->getSourceContext();

        $this->blocks = [
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
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "user/show.html.twig"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "user/show.html.twig"));

        $this->parent = $this->loadTemplate("baseBack.html.twig", "user/show.html.twig", 1);
        $this->parent->display($context, array_merge($this->blocks, $blocks));
        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

    }

    // line 3
    public function block_body($context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "body"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "body"));

        // line 4
        echo "    <div  class=\"main-panel\">
        <div class=\"content-wrapper\">
            <div class=\"page-header\">
                <h3 class=\"page-title\"> Profile </h3>

            </div>
            <div class=\"row\">
                <div class=\"col-md-6 grid-margin stretch-card\">
                    <div class=\"card\">
                        <div class=\"card-body\">
                            <div class=\"row align-items-right\">
                                <div class=\"col-7\">
                                    <h4 class=\"card-title\">User Information</h4>
                                </div>
                                <div class=\"col-4 text-right\" style=\"display: -webkit-box;\">
                                    <a  style=\"margin-left: -23px;\" class=\"btn btn-outline-primary btn-fw\" href=\"";
        // line 19
        echo $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("user_index");
        echo "\">Back</a>
                                    <form style=\" margin-left: 15px;\" method=\"post\" action=\"";
        // line 20
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("user_delete", ["id" => twig_get_attribute($this->env, $this->source, (isset($context["user"]) || array_key_exists("user", $context) ? $context["user"] : (function () { throw new RuntimeError('Variable "user" does not exist.', 20, $this->source); })()), "id", [], "any", false, false, false, 20)]), "html", null, true);
        echo "\" onsubmit=\"return confirm('Are you sure you want to delete this item?');\">
                                        <input type=\"hidden\" name=\"_token\" value=\"";
        // line 21
        echo twig_escape_filter($this->env, $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->renderCsrfToken(("delete" . twig_get_attribute($this->env, $this->source, (isset($context["user"]) || array_key_exists("user", $context) ? $context["user"] : (function () { throw new RuntimeError('Variable "user" does not exist.', 21, $this->source); })()), "id", [], "any", false, false, false, 21))), "html", null, true);
        echo "\">
                                        <button class=\"btn btn-outline-danger btn-fw\">Delete</button>
                                    </form>
                                </div>
                            </div>
                            <form class=\"forms-sample\" readonly=\"true\">
                                <div class=\"form-group\">
                                    <label for=\"exampleInputUsername1\">Username</label>
                                    <input type=\"text\" class=\"form-control\" id=\"exampleInputUsername1\" value=\"";
        // line 29
        echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, (isset($context["user"]) || array_key_exists("user", $context) ? $context["user"] : (function () { throw new RuntimeError('Variable "user" does not exist.', 29, $this->source); })()), "usertag", [], "any", false, false, false, 29), "html", null, true);
        echo "\">
                                </div>
                                <div class=\"form-group\">
                                    <label for=\"exampleInputUsername1\">Full name </label>
                                    <input type=\"text\" class=\"form-control\" id=\"exampleInputUsername1\" value=\"";
        // line 33
        echo twig_escape_filter($this->env, ((twig_get_attribute($this->env, $this->source, (isset($context["user"]) || array_key_exists("user", $context) ? $context["user"] : (function () { throw new RuntimeError('Variable "user" does not exist.', 33, $this->source); })()), "firstname", [], "any", false, false, false, 33) . " ") . twig_get_attribute($this->env, $this->source, (isset($context["user"]) || array_key_exists("user", $context) ? $context["user"] : (function () { throw new RuntimeError('Variable "user" does not exist.', 33, $this->source); })()), "lastname", [], "any", false, false, false, 33)), "html", null, true);
        echo "\">
                                </div>
                                <div class=\"form-group\">
                                    <label for=\"exampleInputEmail1\">Email address</label>
                                    <input type=\"email\" class=\"form-control\" id=\"exampleInputEmail1\" value=\"";
        // line 37
        echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, (isset($context["user"]) || array_key_exists("user", $context) ? $context["user"] : (function () { throw new RuntimeError('Variable "user" does not exist.', 37, $this->source); })()), "email", [], "any", false, false, false, 37), "html", null, true);
        echo "\" >
                                </div>
                                <div class=\"form-group\">
                                    <label for=\"exampleInputEmail1\">phone number</label>
                                    <input  class=\"form-control\" id=\"exampleInputEmail1\" value=\"";
        // line 41
        echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, (isset($context["user"]) || array_key_exists("user", $context) ? $context["user"] : (function () { throw new RuntimeError('Variable "user" does not exist.', 41, $this->source); })()), "phonenumber", [], "any", false, false, false, 41), "html", null, true);
        echo "\">
                                </div>
                                <div class=\"form-group\">
                                    <label for=\"exampleInputPassword1\">last login date</label>
                                    <input  class=\"form-control\" id=\"exampleInputPassword1\"  value=\"";
        // line 45
        echo twig_escape_filter($this->env, twig_date_format_filter($this->env, twig_get_attribute($this->env, $this->source, (isset($context["user"]) || array_key_exists("user", $context) ? $context["user"] : (function () { throw new RuntimeError('Variable "user" does not exist.', 45, $this->source); })()), "lastlogindate", [], "any", false, false, false, 45), "m/d/Y"), "html", null, true);
        echo "\" >
                                </div>


                                <div class=\"col-md-12\">
                                    <div class=\"form-group row\">
                                        <label class=\"col-sm-3 col-form-label\">Roles</label>
                                        ";
        // line 52
        $context['_parent'] = $context;
        $context['_seq'] = twig_ensure_traversable(twig_get_attribute($this->env, $this->source, (isset($context["user"]) || array_key_exists("user", $context) ? $context["user"] : (function () { throw new RuntimeError('Variable "user" does not exist.', 52, $this->source); })()), "roles", [], "any", false, false, false, 52));
        foreach ($context['_seq'] as $context["_key"] => $context["role"]) {
            // line 53
            echo "                                            ";
            if ((0 === twig_compare($context["role"], "ROLE_ADMIN"))) {
                // line 54
                echo "                                                <div class=\"col-sm-2\">
                                                    <div class=\"form-check\">
                                                        <label class=\"form-check-label\">
                                                            <input type=\"checkbox\" class=\"form-check-input\" name=\"membershipRadios\" id=\"membershipRadios1\" value=\"\" checked> ADMIN </label>
                                                    </div>
                                                </div>
                                            ";
            } elseif ((0 === twig_compare(            // line 60
$context["role"], "ROLE_EDITOR"))) {
                // line 61
                echo "                                                <div class=\"col-sm-2\">
                                                    <div class=\"form-check\">
                                                        <label class=\"form-check-label\">
                                                            <input readonly type=\"checkbox\" class=\"form-check-input\" name=\"membershipRadios\" id=\"membershipRadios2\" value=\"option2\" checked> MOD </label>
                                                    </div>
                                                </div>
                                            ";
            } else {
                // line 68
                echo "                                                <div class=\"col-sm-2\">
                                                    <div class=\"form-check\">
                                                        <label class=\"form-check-label\">
                                                            <input type=\"checkbox\" class=\"form-check-input\" name=\"membershipRadios\" id=\"membershipRadios3\" value=\"option3\" checked> USER </label>
                                                    </div>
                                                </div>
                                            ";
            }
            // line 75
            echo "                                        ";
        }
        $_parent = $context['_parent'];
        unset($context['_seq'], $context['_iterated'], $context['_key'], $context['role'], $context['_parent'], $context['loop']);
        $context = array_intersect_key($context, $_parent) + $_parent;
        // line 76
        echo "

                                    </div>
                                </div>
                                <a class=\"btn btn-outline-primary btn-fw\" href=\"";
        // line 80
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("user_edit", ["id" => twig_get_attribute($this->env, $this->source, (isset($context["user"]) || array_key_exists("user", $context) ? $context["user"] : (function () { throw new RuntimeError('Variable "user" does not exist.', 80, $this->source); })()), "id", [], "any", false, false, false, 80)]), "html", null, true);
        echo "\">edit</a>

                            </form>


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
        return "user/show.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  189 => 80,  183 => 76,  177 => 75,  168 => 68,  159 => 61,  157 => 60,  149 => 54,  146 => 53,  142 => 52,  132 => 45,  125 => 41,  118 => 37,  111 => 33,  104 => 29,  93 => 21,  89 => 20,  85 => 19,  68 => 4,  58 => 3,  35 => 1,);
    }

    public function getSourceContext()
    {
        return new Source("{% extends 'baseBack.html.twig' %}

{% block body %}
    <div  class=\"main-panel\">
        <div class=\"content-wrapper\">
            <div class=\"page-header\">
                <h3 class=\"page-title\"> Profile </h3>

            </div>
            <div class=\"row\">
                <div class=\"col-md-6 grid-margin stretch-card\">
                    <div class=\"card\">
                        <div class=\"card-body\">
                            <div class=\"row align-items-right\">
                                <div class=\"col-7\">
                                    <h4 class=\"card-title\">User Information</h4>
                                </div>
                                <div class=\"col-4 text-right\" style=\"display: -webkit-box;\">
                                    <a  style=\"margin-left: -23px;\" class=\"btn btn-outline-primary btn-fw\" href=\"{{ path('user_index') }}\">Back</a>
                                    <form style=\" margin-left: 15px;\" method=\"post\" action=\"{{ path('user_delete', {'id': user.id}) }}\" onsubmit=\"return confirm('Are you sure you want to delete this item?');\">
                                        <input type=\"hidden\" name=\"_token\" value=\"{{ csrf_token('delete' ~ user.id) }}\">
                                        <button class=\"btn btn-outline-danger btn-fw\">Delete</button>
                                    </form>
                                </div>
                            </div>
                            <form class=\"forms-sample\" readonly=\"true\">
                                <div class=\"form-group\">
                                    <label for=\"exampleInputUsername1\">Username</label>
                                    <input type=\"text\" class=\"form-control\" id=\"exampleInputUsername1\" value=\"{{ user.usertag }}\">
                                </div>
                                <div class=\"form-group\">
                                    <label for=\"exampleInputUsername1\">Full name </label>
                                    <input type=\"text\" class=\"form-control\" id=\"exampleInputUsername1\" value=\"{{ user.firstname ~ \" \" ~user.lastname }}\">
                                </div>
                                <div class=\"form-group\">
                                    <label for=\"exampleInputEmail1\">Email address</label>
                                    <input type=\"email\" class=\"form-control\" id=\"exampleInputEmail1\" value=\"{{ user.email }}\" >
                                </div>
                                <div class=\"form-group\">
                                    <label for=\"exampleInputEmail1\">phone number</label>
                                    <input  class=\"form-control\" id=\"exampleInputEmail1\" value=\"{{ user.phonenumber }}\">
                                </div>
                                <div class=\"form-group\">
                                    <label for=\"exampleInputPassword1\">last login date</label>
                                    <input  class=\"form-control\" id=\"exampleInputPassword1\"  value=\"{{ user.lastlogindate|date(\"m/d/Y\") }}\" >
                                </div>


                                <div class=\"col-md-12\">
                                    <div class=\"form-group row\">
                                        <label class=\"col-sm-3 col-form-label\">Roles</label>
                                        {% for role in user.roles %}
                                            {% if role == \"ROLE_ADMIN\" %}
                                                <div class=\"col-sm-2\">
                                                    <div class=\"form-check\">
                                                        <label class=\"form-check-label\">
                                                            <input type=\"checkbox\" class=\"form-check-input\" name=\"membershipRadios\" id=\"membershipRadios1\" value=\"\" checked> ADMIN </label>
                                                    </div>
                                                </div>
                                            {% elseif role == \"ROLE_EDITOR\"%}
                                                <div class=\"col-sm-2\">
                                                    <div class=\"form-check\">
                                                        <label class=\"form-check-label\">
                                                            <input readonly type=\"checkbox\" class=\"form-check-input\" name=\"membershipRadios\" id=\"membershipRadios2\" value=\"option2\" checked> MOD </label>
                                                    </div>
                                                </div>
                                            {% else %}
                                                <div class=\"col-sm-2\">
                                                    <div class=\"form-check\">
                                                        <label class=\"form-check-label\">
                                                            <input type=\"checkbox\" class=\"form-check-input\" name=\"membershipRadios\" id=\"membershipRadios3\" value=\"option3\" checked> USER </label>
                                                    </div>
                                                </div>
                                            {% endif %}
                                        {% endfor %}


                                    </div>
                                </div>
                                <a class=\"btn btn-outline-primary btn-fw\" href=\"{{ path('user_edit', {'id': user.id}) }}\">edit</a>

                            </form>


                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
{% endblock %}
", "user/show.html.twig", "C:\\Users\\Yassine\\Desktop\\gamex_login\\templates\\user\\show.html.twig");
    }
}
