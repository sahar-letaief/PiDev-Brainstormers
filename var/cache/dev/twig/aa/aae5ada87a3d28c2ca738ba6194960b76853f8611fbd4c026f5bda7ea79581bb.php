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

/* registration/confirmation_email.html.twig */
class __TwigTemplate_3683f52ea72ac96ca2f3c4e10a20cea74e96aa5a745bb7e787b87426ed817770 extends Template
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
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "registration/confirmation_email.html.twig"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "registration/confirmation_email.html.twig"));

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
            color: #a7d139!important;
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
        // line 30
        echo twig_escape_filter($this->env, (isset($context["fullName"]) || array_key_exists("fullName", $context) ? $context["fullName"] : (function () { throw new RuntimeError('Variable "fullName" does not exist.', 30, $this->source); })()), "html", null, true);
        echo "</h4>
                </div>
                <div class=\"left-content\" style=\"text-align:center;\">
                    <p style =\"font-weight: BOLD;color: #fcfcfc;margin: auto;font-size: 18px;padding-top: 16px;margin-bottom: 23px;font-family: ui-monospace;height: 101px;background-color: #0b0c2a;border-bottom: 2px dotted red;border-top: 2px dotted red;margin-top: 20px;\"> To activate your GameX Account. <br> please verify your email address.
                        Your account will not be created until your email address is confirmed. <br>
                        This link will expire in ";
        // line 35
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\TranslationExtension']->trans((isset($context["expiresAtMessageKey"]) || array_key_exists("expiresAtMessageKey", $context) ? $context["expiresAtMessageKey"] : (function () { throw new RuntimeError('Variable "expiresAtMessageKey" does not exist.', 35, $this->source); })()), (isset($context["expiresAtMessageData"]) || array_key_exists("expiresAtMessageData", $context) ? $context["expiresAtMessageData"] : (function () { throw new RuntimeError('Variable "expiresAtMessageData" does not exist.', 35, $this->source); })()), "VerifyEmailBundle"), "html", null, true);
        echo ".
                    </p>
                    <button id=\"btn\" style=\"height: 42px;background-color: #b3000d;border-radius: 5px;border: 1px solid #b3000d;width: 15%;margin-top: -11px;\">
                        <a style=\"color:white; display:contents;\"class=\"filled-button\" href=\"";
        // line 38
        echo twig_escape_filter($this->env, (isset($context["signedUrl"]) || array_key_exists("signedUrl", $context) ? $context["signedUrl"] : (function () { throw new RuntimeError('Variable "signedUrl" does not exist.', 38, $this->source); })()), "html", null, true);
        echo "\">Confirm Account</a>
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
        return "registration/confirmation_email.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  88 => 38,  82 => 35,  74 => 30,  43 => 1,);
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
            color: #a7d139!important;
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
                    <h4 style=\"font-size: 22px;font-family: monospace;font-style: normal;color: #ffffff;width: 43%;background-color: #b3000d;margin: auto;border-radius: 10px;border-right: 2px solid white;border-left: 2px solid white;\" >Hello {{ fullName }}</h4>
                </div>
                <div class=\"left-content\" style=\"text-align:center;\">
                    <p style =\"font-weight: BOLD;color: #fcfcfc;margin: auto;font-size: 18px;padding-top: 16px;margin-bottom: 23px;font-family: ui-monospace;height: 101px;background-color: #0b0c2a;border-bottom: 2px dotted red;border-top: 2px dotted red;margin-top: 20px;\"> To activate your GameX Account. <br> please verify your email address.
                        Your account will not be created until your email address is confirmed. <br>
                        This link will expire in {{ expiresAtMessageKey|trans(expiresAtMessageData, 'VerifyEmailBundle') }}.
                    </p>
                    <button id=\"btn\" style=\"height: 42px;background-color: #b3000d;border-radius: 5px;border: 1px solid #b3000d;width: 15%;margin-top: -11px;\">
                        <a style=\"color:white; display:contents;\"class=\"filled-button\" href=\"{{ signedUrl }}\">Confirm Account</a>
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



", "registration/confirmation_email.html.twig", "C:\\Users\\Yassine\\Desktop\\git-login-symfony\\templates\\registration\\confirmation_email.html.twig");
    }
}
