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

/* user/profile_edit_password.html.twig */
class __TwigTemplate_27ff9888383cf55c3f48826726f09d6e4d8b2da9808e20db3d5d2569d724c8dd extends Template
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
        return "baseFront.html.twig";
    }

    protected function doDisplay(array $context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "user/profile_edit_password.html.twig"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "user/profile_edit_password.html.twig"));

        $this->parent = $this->loadTemplate("baseFront.html.twig", "user/profile_edit_password.html.twig", 1);
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
        <section class=\"login spad\">
            <div class=\"container\">
                <div class=\"row\">
                    <div class=\"col-lg-6\">
                        ";
        // line 9
        if ( !twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 9, $this->source); })()), "vars", [], "any", false, false, false, 9), "valid", [], "any", false, false, false, 9)) {
            // line 10
            echo "                            ";
            $context['_parent'] = $context;
            $context['_seq'] = twig_ensure_traversable(twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 10, $this->source); })()), "children", [], "any", false, false, false, 10));
            foreach ($context['_seq'] as $context["_key"] => $context["child"]) {
                // line 11
                echo "                                ";
                $context['_parent'] = $context;
                $context['_seq'] = twig_ensure_traversable(twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, $context["child"], "vars", [], "any", false, false, false, 11), "errors", [], "any", false, false, false, 11));
                foreach ($context['_seq'] as $context["_key"] => $context["error"]) {
                    // line 12
                    echo "                                    <div class=\"alert alert-danger\">";
                    echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, $context["error"], "message", [], "any", false, false, false, 12), "html", null, true);
                    echo "</div>
                                ";
                }
                $_parent = $context['_parent'];
                unset($context['_seq'], $context['_iterated'], $context['_key'], $context['error'], $context['_parent'], $context['loop']);
                $context = array_intersect_key($context, $_parent) + $_parent;
                // line 14
                echo "                            ";
            }
            $_parent = $context['_parent'];
            unset($context['_seq'], $context['_iterated'], $context['_key'], $context['child'], $context['_parent'], $context['loop']);
            $context = array_intersect_key($context, $_parent) + $_parent;
            // line 15
            echo "                        ";
        }
        // line 16
        echo "                    </div>

                </div>
                <div class=\"login__social\">
                    <div class=\"row d-flex justify-content-center\">
                        <div class=\"col-lg-6\">
                            <div class=\"login__social__links\">
                                <div class=\"login__form\">
                                    <h3>Profile Edit</h3>

                                    ";
        // line 26
        echo         $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->renderBlock((isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 26, $this->source); })()), 'form_start', ["render_rest" => false]);
        echo "
                                    <div class=\"input__item\">
                                        ";
        // line 28
        echo $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->searchAndRenderBlock(twig_get_attribute($this->env, $this->source, (isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 28, $this->source); })()), "plainPassword", [], "any", false, false, false, 28), 'widget', ["attr" => ["class" => "form-control"]]);
        echo "
                                        <span class=\"icon_lock\"></span>
                                    </div>
                                    <ul>
                                        <li><button style=\"background-color: #ff4343;border-radius: 4px;color: #ffffff; display: block;font-size: 13px;font-weight: 700;letter-spacing: 2px;text-transform: uppercase;width: 460px;padding: 14px 0;position: relative;margin: 0 auto; \" type=\"submit\" class=\"btn btn-danger btn-fw\">";
        // line 32
        echo twig_escape_filter($this->env, ((array_key_exists("button_label", $context)) ? (_twig_default_filter((isset($context["button_label"]) || array_key_exists("button_label", $context) ? $context["button_label"] : (function () { throw new RuntimeError('Variable "button_label" does not exist.', 32, $this->source); })()), "Save")) : ("Save")), "html", null, true);
        echo "</button></li>

                                        ";
        // line 34
        echo         $this->env->getRuntime('Symfony\Component\Form\FormRenderer')->renderBlock((isset($context["form"]) || array_key_exists("form", $context) ? $context["form"] : (function () { throw new RuntimeError('Variable "form" does not exist.', 34, $this->source); })()), 'form_end');
        echo "
                                        <li><a  class=\"btn btn-primary btn-fw\" href=\"";
        // line 35
        echo $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("profile");
        echo "\">Back</a></li>
                                    </ul>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

    ";
        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

    }

    public function getTemplateName()
    {
        return "user/profile_edit_password.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  138 => 35,  134 => 34,  129 => 32,  122 => 28,  117 => 26,  105 => 16,  102 => 15,  96 => 14,  87 => 12,  82 => 11,  77 => 10,  75 => 9,  68 => 4,  58 => 3,  35 => 1,);
    }

    public function getSourceContext()
    {
        return new Source("{% extends 'baseFront.html.twig' %}

    {% block body %}

        <section class=\"login spad\">
            <div class=\"container\">
                <div class=\"row\">
                    <div class=\"col-lg-6\">
                        {% if not form.vars.valid %}
                            {% for child in  form.children %}
                                {% for error in child.vars.errors %}
                                    <div class=\"alert alert-danger\">{{ error.message }}</div>
                                {% endfor %}
                            {% endfor %}
                        {% endif %}
                    </div>

                </div>
                <div class=\"login__social\">
                    <div class=\"row d-flex justify-content-center\">
                        <div class=\"col-lg-6\">
                            <div class=\"login__social__links\">
                                <div class=\"login__form\">
                                    <h3>Profile Edit</h3>

                                    {{ form_start(form , {render_rest: false}  ,  {'attr' : {'novalidate' : 'novalidate'}}) }}
                                    <div class=\"input__item\">
                                        {{ form_widget(form.plainPassword , {'attr' : {'class' : 'form-control' }}) }}
                                        <span class=\"icon_lock\"></span>
                                    </div>
                                    <ul>
                                        <li><button style=\"background-color: #ff4343;border-radius: 4px;color: #ffffff; display: block;font-size: 13px;font-weight: 700;letter-spacing: 2px;text-transform: uppercase;width: 460px;padding: 14px 0;position: relative;margin: 0 auto; \" type=\"submit\" class=\"btn btn-danger btn-fw\">{{ button_label|default('Save') }}</button></li>

                                        {{ form_end(form) }}
                                        <li><a  class=\"btn btn-primary btn-fw\" href=\"{{ path('profile') }}\">Back</a></li>
                                    </ul>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

    {% endblock %}




", "user/profile_edit_password.html.twig", "C:\\Users\\Yassine\\Desktop\\git-login-symfony\\templates\\user\\profile_edit_password.html.twig");
    }
}
