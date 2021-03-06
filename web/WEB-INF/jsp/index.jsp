<!DOCTYPE html>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">


    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Web Community</title>

        <!-- favicon -->
        <link rel="shortcut icon" href="./resources/img/favicon.ico" type="image/x-icon">
        <link rel="icon" href="./resources/img/favicon.ico" type="image/x-icon">

        <!-- Bootstrap Core CSS - Uses Bootswatch Flatly Theme: http://bootswatch.com/flatly/ -->
        <link href="./resources/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="./resources/css/freelancer.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="./resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>

    <body id="page-top" class="index">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header page-scroll">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#page-top">Web Community</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="hidden">
                            <a href="#page-top"></a>
                        </li>
                        <li class="page-scroll">
                            <a href="./eventi">Eventi</a>
                        </li>
                        <li class="page-scroll">
                            <a href="./login">Login</a>
                        </li>
                        <li class="page-scroll">
                            <a href="./registrazione">Registrati</a>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container-fluid -->
        </nav>

        <!-- Header -->
        <header>
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <img class="img-responsive" style="width:200px" src="./resources/img/logo.png" alt="">
                        <div class="intro-text">
                            <span class="name">Web Community</span>
                            <hr class="star-light">
                            <span class="skills">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</span>
                        </div>
                    </div>
                </div>
            </div>
        </header>

        <!-- Portfolio Grid Section -->
        <section id="portfolio">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <h2>Prossimi Eventi</h2>
                        <hr class="star-primary">
                    </div>
                </div>
                <div class="row">

                    <c:forEach items="${eventi}" var="e">
                        <div class="col-sm-4 portfolio-item">
                            <a href="#" onclick="apriModal(${e.idEvento})" class="portfolio-link" data-toggle="modal">
                                <div class="caption">
                                    <div class="caption-content">
                                        <i class="fa fa-search-plus fa-3x"></i>
                                        <br/><br/>${e.titolo}
                                    </div>
                                </div>
                                <img src="${e.foto}" style="width: 393px; height: 284px;" class="img-responsive" alt="">
                            </a>
                        </div>
                    </c:forEach>

                </div>
            </div>
        </section>

        <!-- Footer -->
        <footer class="text-center">
            <div class="footer-above">
                <div class="container">
                    <div class="row">
                        <div class="footer-col col-md-4">
                            <h3>Location</h3>
                            <p>Via L. Pettinati, 46<br>35129 Padova (PD)</p>
                        </div>
                        <div class="footer-col col-md-4">
                            <h3>Around the Web</h3>
                            <ul class="list-inline">
                                <li>
                                    <a href="#!" class="btn-social btn-outline"><i class="fa fa-fw fa-facebook"></i></a>
                                </li>
                                <li>
                                    <a href="#!" class="btn-social btn-outline"><i class="fa fa-fw fa-google-plus"></i></a>
                                </li>
                                <li>
                                    <a href="#!" class="btn-social btn-outline"><i class="fa fa-fw fa-twitter"></i></a>
                                </li>
                            </ul>
                        </div>
                        <div class="footer-col col-md-4">
                            <h3>About Web Community</h3>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="footer-below">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            Copyright &copy; Magro, Ramescu, Scagnellato, Sturza | 2016
                        </div>
                    </div>
                </div>
            </div>
        </footer>

        <!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
        <div class="scroll-top page-scroll visible-xs visible-sm">
            <a class="btn btn-primary" href="#page-top">
                <i class="fa fa-chevron-up"></i>
            </a>
        </div>

        <c:forEach items="${eventi}" var="e">
            <!-- Portfolio Modals -->
            <div class="portfolio-modal modal fade" id="modal${e.idEvento}" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-content">
                    <div class="close-modal" data-dismiss="modal">
                        <div class="lr">
                            <div class="rl">
                            </div>
                        </div>
                    </div>
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-8 col-lg-offset-2">
                                <div class="modal-body">
                                    <h2>${e.titolo}</h2>
                                    <hr class="star-primary">
                                    <img src="${e.foto}" class="img-responsive img-centered" alt="">
                                    <p>${e.descrizione}</p>
                                    <ul class="list-inline item-details">
                                        <li>Inserito da:
                                            <strong><a>${e.utente.nickname}</a>
                                            </strong>
                                        </li>
                                        <li>Data Evento:
                                            <strong><a>${e.data}</a>
                                            </strong>
                                        </li>
                                        <li>Luogo Evento:
                                            <strong><a>${e.luogo}</a>
                                            </strong>
                                        </li>
                                    </ul>
                                    <hr><br/>
                                    <h5>Commenti</h5>
                                    <c:forEach items="${commenti}" var="c">
                                        <c:if test="${c.evento.idEvento == e.idEvento}">
                                            <ul class="list-inline item-details">
                                                <li><strong>Commento:</strong>
                                                    ${c.commento}
                                                </li>
                                                <br/>
                                                <li>
                                                    <strong>Voto:</strong>
                                                    ${c.voto}
                                                </li>
                                            </ul>
                                        </c:if>
                                    </c:forEach>

                                    <form name="addCommento" id="addCommento" novalidate>
                                        <div class="row control-group">
                                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                                <label style="text-align:left">Commento</label>
                                                <input type="text" class="form-control" placeholder="Aggiungi un commento..." id="nomeUtente" required data-validation-required-message="Inserisci il tuo nome utente">
                                                <p class="help-block text-danger"></p>
                                            </div>
                                        </div>
                                        <div id="success"></div>
                                        <br/>
                                        <strong>Voto:  </strong>
                                        <label class="radio-inline"><input type="radio" name="voto">1</label>
                                        <label class="radio-inline"><input type="radio" name="voto">2</label>
                                        <label class="radio-inline"><input type="radio" name="voto" checked>3</label> 
                                        <label class="radio-inline"><input type="radio" name="voto">4</label>
                                        <label class="radio-inline"><input type="radio" name="voto">5</label> 
                                        <br/>
                                        <br/>
                                        <div class="row">
                                            <div class="form-group col-xs-12">
                                                <button type="submit" class="btn btn-success btn-lg">Invia</button>
                                            </div>
                                        </div>
                                    </form>
                                    
                                    <br/>


                                    <button type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-times"></i> Close</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>


        <!-- jQuery -->
        <script src="./resources/js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="./resources/js/bootstrap.min.js"></script>

        <!-- Plugin JavaScript -->
        <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
        <script src="./resources/js/classie.js"></script>
        <script src="./resources/js/cbpAnimatedHeader.js"></script>

        <!-- Contact Form JavaScript -->
        <script src="./resources/js/jqBootstrapValidation.js"></script>
        <script src="./resources/js/contact_me.js"></script>

        <!-- Custom Theme JavaScript -->
        <script src="./resources/js/freelancer.js"></script>

        <script>
                                function apriModal(id) {
                                    $("#modal" + id).modal();
                                }
        </script>

    </body>

</html>
