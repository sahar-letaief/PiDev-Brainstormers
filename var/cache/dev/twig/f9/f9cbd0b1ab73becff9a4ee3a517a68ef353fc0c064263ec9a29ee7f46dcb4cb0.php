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

/* user/edit.html.twig */
class __TwigTemplate_1d40051fc4b4b440f585959d78dad71ab7b6f3349aee6fd707a340872392516d extends Template
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
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "user/edit.html.twig"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "user/edit.html.twig"));

        $this->parent = $this->loadTemplate("baseBack.html.twig", "user/edit.html.twig", 1);
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
        echo "
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
                                        <a  style=\"margin-left: -23px;\" class=\"btn btn-outline-primary btn-fw\" href=\"";
        // line 21
        echo $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("user_index");
        echo "\">Back</a>
                                        <form style=\" margin-left: 15px;\" method=\"post\" action=\"";
        // line 22
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("user_delete", ["id" => twig_get_attribute($this->env, $this->source, (isset($context["user"]) || array_key_exists("user", $context) ? $context["user"] : (function () { throw new RuntimeError('Variable "user" does not exist.', 22, $this->source); })()), "id", [], "any", false, false, false, 22)]), "html", null, true);
        echo "\" onsubmit=\"return confirm('Are you sure you want to delete this item?');\">
                                            <input type=\"hidden\" name=\"_token\" value=\"";
        // line 23
        echo twig_escape_filter($this->env, $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->renderCsrfToken(("delete" . twig_get_attribute($this->env, $this->source, (isset($context["user"]) || array_key_exists("user", $context) ? $context["user"] : (function () { throw new RuntimeError('Variable "user" does not exist.', 23, $this->source); })()), "id", [], "any", false, false, false, 23))), "html", null, true);
        echo "\">
                                            <button class=\"btn btn-outline-danger btn-fw\">Delete</button>
                                        </form>
                                    </div>
                                </div>
                                <div class=\"row align-items-center\">
                                    <div class=\"col-12\">
                                        ";
        // line 30
        if ( !twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 30, $this->source); })()), "vars", [], "any", false, false, false, 30), "valid", [], "any", false, false, false, 30)) {
            // line 31
            echo "                                            ";
            $context['_parent'] = $context;
            $context['_seq'] = twig_ensure_traversable(twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 31, $this->source); })()), "children", [], "any", false, false, false, 31));
            foreach ($context['_seq'] as $context["_key"] => $context["child"]) {
                // line 32
                echo "                                                ";
                $context['_parent'] = $context;
                $context['_seq'] = twig_ensure_traversable(twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, $context["child"], "vars", [], "any", false, false, false, 32), "errors", [], "any", false, false, false, 32));
                foreach ($context['_seq'] as $context["_key"] => $context["error"]) {
                    // line 33
                    echo "                                                    <div class=\"alert alert-danger\">";
                    echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, $context["error"], "message", [], "any", false, false, false, 33), "html", null, true);
                    echo "</div>
                                                ";
                }
                $_parent = $context['_parent'];
                unset($context['_seq'], $context['_iterated'], $context['_key'], $context['error'], $context['_parent'], $context['loop']);
                $context = array_intersect_key($context, $_parent) + $_parent;
                // line 35
                echo "                                            ";
            }
            $_parent = $context['_parent'];
            unset($context['_seq'], $context['_iterated'], $context['_key'], $context['child'], $context['_parent'], $context['loop']);
            $context = array_intersect_key($context, $_parent) + $_parent;
            // line 36
            echo "                                        ";
        }
        // line 37
        echo "                                    </div>
                                </div>

                                <p class=\"card-description\">  </p>

                                ";
        // line 42
        echo         $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->renderBlock((isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 42, $this->source); })()), 'form_start', ["render_rest" => false]);
        echo "
                                <div class=\"form-group\">
                                    <label for=\"exampleInputUsername1\">Email</label>
                                    ";
        // line 45
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 45, $this->source); })()), "email", [], "any", false, false, false, 45), 'widget', ["attr" => ["class" => "form-control"]]);
        echo "
                                </div>
                                <div class=\"form-group\">
                                    <label for=\"exampleInputPassword1\">Username</label>
                                    ";
        // line 49
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 49, $this->source); })()), "usertag", [], "any", false, false, false, 49), 'widget', ["attr" => ["class" => "form-control"]]);
        echo "
                                </div>
                                <div class=\"form-group\">
                                    <label >First name</label>
                                    ";
        // line 53
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 53, $this->source); })()), "firstname", [], "any", false, false, false, 53), 'widget', ["attr" => ["class" => "form-control"]]);
        echo "
                                </div>
                                <div class=\"form-group\">
                                    <label for=\"exampleInputPassword1\">last name</label>
                                    ";
        // line 57
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 57, $this->source); })()), "lastname", [], "any", false, false, false, 57), 'widget', ["attr" => ["class" => "form-control"]]);
        echo "
                                </div>
                                <div class=\"form-group\">
                                    <label for=\"exampleInputPassword1\">Phone Number</label>
                                    ";
        // line 61
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 61, $this->source); })()), "phone_number", [], "any", false, false, false, 61), 'widget', ["attr" => ["class" => "form-control"]]);
        echo "
                                </div>

                            <div style=\"display: flex\">

                                <div class=\"col-md-6\">
                                    <div class=\"form-group\">
                                        <div class=\"form-check\">
                                            <label class=\"form-check-label\">
                                                ";
        // line 70
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 70, $this->source); })()), "roles", [], "any", false, false, false, 70), 0, [], "array", false, false, false, 70), 'label');
        echo "

                                                ";
        // line 72
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 72, $this->source); })()), "roles", [], "any", false, false, false, 72), 0, [], "array", false, false, false, 72), 'widget', ["attr" => ["class" => "form-control"]]);
        echo "
                                        </div>
                                        <div class=\"form-check\">
                                            <label class=\"form-check-label\">
                                                ";
        // line 76
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 76, $this->source); })()), "roles", [], "any", false, false, false, 76), 1, [], "array", false, false, false, 76), 'label');
        echo "
                                                ";
        // line 77
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 77, $this->source); })()), "roles", [], "any", false, false, false, 77), 1, [], "array", false, false, false, 77), 'widget', ["attr" => ["type" => "radio"]]);
        echo "
                                        </div>
                                        <div class=\"form-check\">
                                            <label class=\"form-check-label\">
                                                ";
        // line 81
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 81, $this->source); })()), "roles", [], "any", false, false, false, 81), 2, [], "array", false, false, false, 81), 'label');
        echo "
                                            ";
        // line 82
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 82, $this->source); })()), "roles", [], "any", false, false, false, 82), 2, [], "array", false, false, false, 82), 'widget', ["attr" => ["type" => "radio"]]);
        echo "
                                        </div>
                                        <div class=\"form-check\">
                                            <label class=\"form-check-label\">
                                                ";
        // line 86
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 86, $this->source); })()), "roles", [], "any", false, false, false, 86), 3, [], "array", false, false, false, 86), 'label');
        echo "
                                            ";
        // line 87
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 87, $this->source); })()), "roles", [], "any", false, false, false, 87), 3, [], "array", false, false, false, 87), 'widget', ["attr" => ["type" => "radio"]]);
        echo "
                                        </div>

                                    </div>
                                </div>

                                <div class=\"col-md-6\">
                                    <div class=\"form-group\">
                                        <div class=\"form-check\">
                                            <label class=\"form-check-label\">
                                                ";
        // line 97
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 97, $this->source); })()), "roles", [], "any", false, false, false, 97), 4, [], "array", false, false, false, 97), 'label');
        echo "
                                                ";
        // line 98
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 98, $this->source); })()), "roles", [], "any", false, false, false, 98), 4, [], "array", false, false, false, 98), 'widget', ["attr" => ["type" => "radio"]]);
        echo "
                                        </div>
                                        <div class=\"form-check\">
                                            <label class=\"form-check-label\">
                                                ";
        // line 102
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 102, $this->source); })()), "roles", [], "any", false, false, false, 102), 5, [], "array", false, false, false, 102), 'label');
        echo "
                                                ";
        // line 103
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 103, $this->source); })()), "roles", [], "any", false, false, false, 103), 5, [], "array", false, false, false, 103), 'widget', ["attr" => ["type" => "radio"]]);
        echo "
                                        </div>
                                        <div class=\"form-check\">
                                            <label class=\"form-check-label\">
                                                ";
        // line 107
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 107, $this->source); })()), "roles", [], "any", false, false, false, 107), 6, [], "array", false, false, false, 107), 'label');
        echo "
                                                ";
        // line 108
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 108, $this->source); })()), "roles", [], "any", false, false, false, 108), 6, [], "array", false, false, false, 108), 'widget', ["attr" => ["type" => "radio"]]);
        echo "
                                        </div>
                                    </div>
                                </div>

                            </div>

                                <button type=\"submit\" class=\"btn btn-outline-primary btn-fw\">";
        // line 115
        echo twig_escape_filter($this->env, ((array_key_exists("button_label", $context)) ? (_twig_default_filter((isset($context["button_label"]) || array_key_exists("button_label", $context) ? $context["button_label"] : (function () { throw new RuntimeError('Variable "button_label" does not exist.', 115, $this->source); })()), "Save")) : ("Save")), "html", null, true);
        echo "</button>

                                ";
        // line 117
        echo         $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->renderBlock((isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 117, $this->source); })()), 'form_end');
        echo "

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
        return "user/edit.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  280 => 117,  275 => 115,  265 => 108,  261 => 107,  254 => 103,  250 => 102,  243 => 98,  239 => 97,  226 => 87,  222 => 86,  215 => 82,  211 => 81,  204 => 77,  200 => 76,  193 => 72,  188 => 70,  176 => 61,  169 => 57,  162 => 53,  155 => 49,  148 => 45,  142 => 42,  135 => 37,  132 => 36,  126 => 35,  117 => 33,  112 => 32,  107 => 31,  105 => 30,  95 => 23,  91 => 22,  87 => 21,  68 => 4,  58 => 3,  35 => 1,);
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
                                <div class=\"row align-items-center\">
                                    <div class=\"col-12\">
                                        {% if not form.vars.valid %}
                                            {% for child in  form.children %}
                                                {% for error in child.vars.errors %}
                                                    <div class=\"alert alert-danger\">{{ error.message }}</div>
                                                {% endfor %}
                                            {% endfor %}
                                        {% endif %}
                                    </div>
                                </div>

                                <p class=\"card-description\">  </p>

                                {{ form_start(form , {render_rest: false}  ,  {'attr' : {'novalidate' : 'novalidate'}}) }}
                                <div class=\"form-group\">
                                    <label for=\"exampleInputUsername1\">Email</label>
                                    {{ form_widget(form.email , {'attr' : {'class' : 'form-control' }}) }}
                                </div>
                                <div class=\"form-group\">
                                    <label for=\"exampleInputPassword1\">Username</label>
                                    {{ form_widget(form.usertag , {'attr' : {'class' : 'form-control' }}) }}
                                </div>
                                <div class=\"form-group\">
                                    <label >First name</label>
                                    {{ form_widget(form.firstname , {'attr' : {'class' : 'form-control' }}) }}
                                </div>
                                <div class=\"form-group\">
                                    <label for=\"exampleInputPassword1\">last name</label>
                                    {{ form_widget(form.lastname , {'attr' : {'class' : 'form-control' }}) }}
                                </div>
                                <div class=\"form-group\">
                                    <label for=\"exampleInputPassword1\">Phone Number</label>
                                    {{ form_widget(form.phone_number , {'attr' : {'class' : 'form-control' }}) }}
                                </div>

                            <div style=\"display: flex\">

                                <div class=\"col-md-6\">
                                    <div class=\"form-group\">
                                        <div class=\"form-check\">
                                            <label class=\"form-check-label\">
                                                {{ form_label(form.roles[0])  }}

                                                {{ form_widget(form.roles[0], {'attr' : {'class' : 'form-control' }}) }}
                                        </div>
                                        <div class=\"form-check\">
                                            <label class=\"form-check-label\">
                                                {{ form_label(form.roles[1])  }}
                                                {{ form_widget(form.roles[1], {'attr' : {'type' : 'radio' }})  }}
                                        </div>
                                        <div class=\"form-check\">
                                            <label class=\"form-check-label\">
                                                {{ form_label(form.roles[2])  }}
                                            {{ form_widget(form.roles[2], {'attr' : {'type' : 'radio' }}) }}
                                        </div>
                                        <div class=\"form-check\">
                                            <label class=\"form-check-label\">
                                                {{ form_label(form.roles[3])  }}
                                            {{ form_widget(form.roles[3], {'attr' : {'type' : 'radio' }})  }}
                                        </div>

                                    </div>
                                </div>

                                <div class=\"col-md-6\">
                                    <div class=\"form-group\">
                                        <div class=\"form-check\">
                                            <label class=\"form-check-label\">
                                                {{ form_label(form.roles[4])  }}
                                                {{ form_widget(form.roles[4], {'attr' : {'type' : 'radio' }}) }}
                                        </div>
                                        <div class=\"form-check\">
                                            <label class=\"form-check-label\">
                                                {{ form_label(form.roles[5])  }}
                                                {{ form_widget(form.roles[5], {'attr' : {'type' : 'radio' }})  }}
                                        </div>
                                        <div class=\"form-check\">
                                            <label class=\"form-check-label\">
                                                {{ form_label(form.roles[6])  }}
                                                {{ form_widget(form.roles[6], {'attr' : {'type' : 'radio' }}) }}
                                        </div>
                                    </div>
                                </div>

                            </div>

                                <button type=\"submit\" class=\"btn btn-outline-primary btn-fw\">{{ button_label|default('Save') }}</button>

                                {{ form_end(form) }}

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    {% endblock %}




", "user/edit.html.twig", "C:\\Users\\Yassine\\Desktop\\gamex_login\\templates\\user\\edit.html.twig");
    }
}
