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

/* security/reset_email.html.twig */
class __TwigTemplate_c18f6ebec84c1965a8b89eefd86043a77cbbd46efda0034f1d82c95276e8a16c extends Template
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
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "security/reset_email.html.twig"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "security/reset_email.html.twig"));

        // line 1
        echo "
<!DOCTYPE html>
<html lang=\"en\">
<head>
    <meta charset=\"utf-8\">
    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
    <meta name=\"description\" content=\"\">
    <meta name=\"author\" content=\"\">
    <link href=\"https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&display=swap\" rel=\"stylesheet\">

    <style>
        .left-content a:hover {
            font-size: 15px;
        }
    </style>

</head>
<body>
<div class=\"best-features\">
    <div class=\"container\" style=\"max-width: 984px;width: 100%; margin-right: auto;background-color: #0b0c2a;margin-left: auto; height: 600px; border-radius: 0px 0px 10px 10px;\">
        <div class=\"row\">
            <div class=\"col-md-12\" style=\" width: 100%;margin: auto;\">
                <div class=\"right-image\" style=\"box-sizing: border-box;\">
                    <img style=\"width: 983px;\" src=\"https://i.ibb.co/0Qd2rTr/GAMEX2.png\">
                </div>
            </div>
            <div class=\"col-md-12\" style=\"\">
                <div class=\"middle-content\" style=\"text-align:center;\">
                    <h4 style=\"font-size: 22px;font-family: monospace;font-style: normal;color: #ffffff;width: 43%;background-color: #b3000d;margin: auto;border-radius: 10px;border-right: 2px solid white;border-left: 2px solid white;\" >Hello ";
        // line 29
        echo twig_escape_filter($this->env, (isset($context["fullname"]) || array_key_exists("fullname", $context) ? $context["fullname"] : (function () { throw new RuntimeError('Variable "fullname" does not exist.', 29, $this->source); })()), "html", null, true);
        echo "</h4>
                </div>
                <div class=\"left-content\" style=\"text-align:center;\">
                    <p style =\"font-weight: BOLD;color: #fcfcfc;margin: auto;font-size: 18px;padding-top: 16px;margin-bottom: 23px;font-family: ui-monospace;height: 101px;background-color: #0b0c2a;border-bottom: 2px dotted red;border-top: 2px dotted red;margin-top: 20px;\"> To Reset your GameX Account. <br> please proceed onto clicking the button below to complete resetting your Password .</p>

                    <button id=\"btn\" style=\"height: 42px;background-color: #b3000d;border-radius: 5px;border: 1px solid #b3000d;width: 15%;margin-top: -11px;\">
                        <a style=\"color:white; display:contents;\"class=\"filled-button\" href=\"";
        // line 35
        echo twig_escape_filter($this->env, (isset($context["url"]) || array_key_exists("url", $context) ? $context["url"] : (function () { throw new RuntimeError('Variable "url" does not exist.', 35, $this->source); })()), "html", null, true);
        echo "\">Reset</a>
                    </button>
                </div>
            </div>
        </div>
        <footer>
            <div class=\"container\" style=\"margin: auto;margin-top: 24px;\">
                <div class=\"row\">
                    <div class=\"col-md-12\">
                        <div class=\"inner-content\" style=\"padding-top: 16px;padding-bottom: 16px;color: white;\">
                            <p style=\"padding-top: 16px;padding-bottom: 16px;background: #b3000d;color: white;width: 38%;margin: auto;text-align: center;border-radius: 10px;border-right: 2px solid white;border-left: 2px solid white;\">Copyright &copy; 2022 GameX.</p>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
    </div>

</div>


</body>
</html>




";
        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

    }

    public function getTemplateName()
    {
        return "security/reset_email.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  82 => 35,  73 => 29,  43 => 1,);
    }

    public function getSourceContext()
    {
        return new Source("
<!DOCTYPE html>
<html lang=\"en\">
<head>
    <meta charset=\"utf-8\">
    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
    <meta name=\"description\" content=\"\">
    <meta name=\"author\" content=\"\">
    <link href=\"https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&display=swap\" rel=\"stylesheet\">

    <style>
        .left-content a:hover {
            font-size: 15px;
        }
    </style>

</head>
<body>
<div class=\"best-features\">
    <div class=\"container\" style=\"max-width: 984px;width: 100%; margin-right: auto;background-color: #0b0c2a;margin-left: auto; height: 600px; border-radius: 0px 0px 10px 10px;\">
        <div class=\"row\">
            <div class=\"col-md-12\" style=\" width: 100%;margin: auto;\">
                <div class=\"right-image\" style=\"box-sizing: border-box;\">
                    <img style=\"width: 983px;\" src=\"https://i.ibb.co/0Qd2rTr/GAMEX2.png\">
                </div>
            </div>
            <div class=\"col-md-12\" style=\"\">
                <div class=\"middle-content\" style=\"text-align:center;\">
                    <h4 style=\"font-size: 22px;font-family: monospace;font-style: normal;color: #ffffff;width: 43%;background-color: #b3000d;margin: auto;border-radius: 10px;border-right: 2px solid white;border-left: 2px solid white;\" >Hello {{ fullname }}</h4>
                </div>
                <div class=\"left-content\" style=\"text-align:center;\">
                    <p style =\"font-weight: BOLD;color: #fcfcfc;margin: auto;font-size: 18px;padding-top: 16px;margin-bottom: 23px;font-family: ui-monospace;height: 101px;background-color: #0b0c2a;border-bottom: 2px dotted red;border-top: 2px dotted red;margin-top: 20px;\"> To Reset your GameX Account. <br> please proceed onto clicking the button below to complete resetting your Password .</p>

                    <button id=\"btn\" style=\"height: 42px;background-color: #b3000d;border-radius: 5px;border: 1px solid #b3000d;width: 15%;margin-top: -11px;\">
                        <a style=\"color:white; display:contents;\"class=\"filled-button\" href=\"{{ url }}\">Reset</a>
                    </button>
                </div>
            </div>
        </div>
        <footer>
            <div class=\"container\" style=\"margin: auto;margin-top: 24px;\">
                <div class=\"row\">
                    <div class=\"col-md-12\">
                        <div class=\"inner-content\" style=\"padding-top: 16px;padding-bottom: 16px;color: white;\">
                            <p style=\"padding-top: 16px;padding-bottom: 16px;background: #b3000d;color: white;width: 38%;margin: auto;text-align: center;border-radius: 10px;border-right: 2px solid white;border-left: 2px solid white;\">Copyright &copy; 2022 GameX.</p>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
    </div>

</div>


</body>
</html>




", "security/reset_email.html.twig", "C:\\Users\\Yassine\\Desktop\\git-login-symfony\\templates\\security\\reset_email.html.twig");
    }
}
