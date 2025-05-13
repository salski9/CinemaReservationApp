<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
    <title>Home - Réservation de Films</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
    	html {
    		scroll-behavior: smooth;
		}	
        body {
            background: url('images/cinema.jpg') no-repeat center center fixed;
            background-size: cover;
            font-family: 'Arial', sans-serif;
            color: #ffffff;
            margin: 0;
            padding: 0;
            overflow-x: hidden;
        }
        .overlay {
            background-color: rgba(0, 0, 0, 0.7);
            min-height: 100vh;
            display: flex;
            flex-direction: column;
        }
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #000;
            padding: 20px 40px;
            color: #ff0000;
            position: sticky;
            top: 0;
            z-index: 1000;
        }
        .logo img {
            max-height: 60px;
            width: auto;
            filter: drop-shadow(0 0 8px rgba(255,0,0,0.5));
        }
        /* Button Variants */
        .btn-red {
            background-color: #e50914;
            color: #fff;
            border: none;
            box-shadow: 0 4px 12px rgba(229,9,20,0.3);
            border-radius: 30px;
            transition: all .3s;
        }
        .btn-red:hover {
            background-color: #b20710;
            transform: translateY(-1px);
        }
        .btn-outline-red {
            border: 2px solid #e50914;
            color: #e50914;
            background-color: transparent;
            border-radius: 30px;
            transition: all .3s;
        }
        .btn-outline-red:hover {
            background-color: #e50914;
            color: #fff;
        }
        /* Movies Section - Compact Version */
.movies-section {
    padding: 50px 30px;
    position: relative;
    overflow: hidden; /* Hide the default scrollbar */
}

.movies-carousel {
    display: flex;
    gap: 25px;
    overflow-x: auto;
    scroll-behavior: smooth; /* Enables smooth scrolling */
    scroll-snap-type: none; /* Remove snap points for continuous scroll */
    padding: 25px 0;
    -webkit-overflow-scrolling: touch; /* Smooth scrolling on iOS */
    scrollbar-width: none; /* Hide scrollbar in Firefox */
}

.movies-carousel::-webkit-scrollbar {
    display: none;
}

.film-card {
    flex: 0 0 250px; /* Reduced from 300px */
    background: rgba(0,0,0,0.8);
    border-radius: 12px;
    overflow: hidden;
    transition: all 0.3s cubic-bezier(0.25, 0.8, 0.25, 1);
    box-shadow: 0 6px 18px rgba(0,0,0,0.3);
}

.film-card:hover {
    transform: translateY(-3px); /* More subtle hover effect */
    box-shadow: 0 10px 28px rgba(0,0,0,0.4);
}

.card-img {
    height: 350px; /* Reduced from 400px */
    background-size: cover;
    background-position: center;
    position: relative;
    border-bottom: 2px solid #e50914; /* Thinner border */
}

.card-img::after {
    content: '';
    position: absolute;
    bottom: 0;
    left: 0;
    right: 0;
    height: 50%; /* Reduced gradient overlay */
    background: linear-gradient(transparent, rgba(0,0,0,0.85));
}

.card-body {
    padding: 15px; /* Reduced padding */
    position: relative;
    z-index: 1;
}

.card-title {
    font-size: 1.2rem; /* Slightly smaller title */
    font-weight: 600;
    margin-bottom: 8px;
}

.card-text {
    color: #aaa;
    font-size: 0.85rem; /* Slightly smaller text */
    margin-bottom: 6px;
    line-height: 1.4;
}
        .card-rating { background:rgba(229,9,20,0.9); color:#fff; padding:4px 10px; border-radius:20px; font-size:.8rem; }
        .btn-reserve {
            background:#e50914; color:#fff; border:none; padding:10px 25px; border-radius:25px;
            width:100%; font-weight:600; text-transform:uppercase; letter-spacing:.5px; transition:.3s;
        }
        .btn-reserve:hover { background:#b20710; transform:scale(1.05); }
        .carousel-control { position:absolute; top:50%; transform:translateY(-50%); width:40px; height:40px; display:flex; align-items:center; justify-content:center; border-radius:50%; background:rgba(255,255,255,0.1); color:#fff; transition:all .3s; opacity:.5; }
        .carousel-control:hover { background:rgba(229,9,20,0.9); transform:translateY(-50%) scale(1.1); }
        .prev { left:20px; }
        .next { right:20px; }
        @keyframes bounce {0%,20%,50%,80%,100%{transform:translateY(0);}40%{transform:translateY(-10px);}60%{transform:translateY(-5px);}}
        /* Integrated Description Section */
        .description-section {
            display: flex;
            justify-content: center;
            padding: 50px 20px;
        }
        .description-section .description {
            background: rgba(0,0,0,0.7);
            border-radius: 15px;
            padding: 30px;
            max-width: 800px;
            text-align: center;
            backdrop-filter: blur(5px);
        }
        .description-section h2 {
            font-size: 2rem;
            margin-bottom: 15px;
        }
        .description-section p {
            font-size: 1rem;
            color: #ccc;
        }
        .top-sidebar-container {
		    display: flex;
		    justify-content: flex-end;
		    width: 100%;
		    padding: 20px 40px 0 0;
		}
		
		.sidebar {
		    width: 300px;
		    background-color: rgba(0, 0, 0, 0.9);
		    padding: 20px;
		    border-radius: 15px;
		}


        .sidebar h3 {
            color: #ff0000;
        }

        .sidebar p {
            color: #ccc;
        }

        
        .modal-backdrop.show {
            opacity: 0.7;
            backdrop-filter: blur(5px);
        }
		
		/* Reuse the login card style */
		.register-card {
		    backdrop-filter: blur(8px);
		    background-color: rgba(255, 255, 255, 0.05);
		    border: 1px solid rgba(255, 255, 255, 0.2);
		    border-radius: 15px;
		    padding: 30px;
		    color: white;
		    width: 100%;
		    max-width: 400px;
		    margin: auto;
		}
		
		.register-card h5 {
		    color: white;
		    text-align: center;
		    margin-bottom: 20px;
		}
		.footer {
            background-color: #000;
            color: white;
            text-align: center;
            padding: 8px;
            font-size: 0.9rem;
            margin-top: auto;
        }
    </style>
</head>
<body>
<div class="overlay">
    <!-- Header -->
    <div class="header">
        <div class="logo">
            <img src="images/logoCinema.png" alt="Logo Cinema">
        </div>
        <div class="nav-buttons d-flex gap-3 align-items-center">
            <!-- If NOT logged in -->
            <c:if test="${not sessionScope.isLoggedIn}">
                <button class="btn btn-outline-red" data-bs-toggle="modal" data-bs-target="#registerModal">
                    <i class="bi bi-person-plus-fill me-1"></i> Register
                </button>
                <button class="btn btn-red" onclick="window.location.href='login.jsp';">
                    <i class="bi bi-box-arrow-in-right me-1"></i> Login
                </button>
            </c:if>
            <!-- If logged in -->
            <c:if test="${sessionScope.isLoggedIn}">
                <span class="fw-semibold text-white me-2">Welcome, ${sessionScope.compte.name}!</span>
                <button class="btn btn-outline-red" onclick="window.location.href='user.jsp';">
                    <i class="bi bi-person-circle me-1"></i> Profil
                </button>
                <form method="POST" action="controleur" class="d-inline">
                    <button type="submit" name="action" value="logout" class="btn btn-outline-red">
                        <i class="bi bi-box-arrow-right me-1"></i> Logout
                    </button>
                </form>
            </c:if>
        </div>
    </div>
	
	
    <!-- Description Section -->
    <div class="description-section">
        <div class="description">
            <h2>Welcome to <span style="color: #e50914; font-weight: bold;">TfarejTV</span></h2>
			<p>Enjoy an exceptional selection of movies, easily book your seats, and experience unforgettable cinematic moments.</p>
        </div>
    </div>
	
    <!-- Movies Section -->
    <div class="movies-section">
        <h2 class="text-center mb-5" style="color: #e50914; font-size: 2.5rem; text-shadow: 0 2px 4px rgba(0,0,0,0.5);">
            Hot Releases – Book Before It’s Too Late!
        </h2>
        <div class="position-relative">
            
            <div class="movies-carousel">
                <c:forEach var="c" items="${TousLesFilms}">
                    <div class="film-card">
                        <div class="card-img" style="background-image: url('${c.urlPhoto}');">
                            <div class="card-details position-absolute top-0 start-0 m-3">
                                <span class="card-rating">⭐ /10</span>
                            </div>
                        </div>
                        <div class="card-body">
                            <h5 class="card-title">${c.nom}</h5>
                            <div class="card-text ">Screening Date: <strong><span class="text-danger">${c.dateProj}</span></strong>
</div>
                            <div class="card-text">Director: <strong>${c.realisateur}</strong> </div>
                            
                            <div class="card-text">Duration: mins</div>
                            
                            <form action="controleur" method="post" class="mt-3">
                                <input type="hidden" name="filmId" value="${c.id_film}">
                                <button type="submit" class="btn-reserve" name="action" value="reserver">
                                    RESERVE NOW
                                </button>
                            </form>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <button class="carousel-control next" onclick="scrollHorizontally(300)">
                <i class="bi bi-chevron-right"></i>
            </button>
            <button class="carousel-control prev" onclick="scrollHorizontally(-300)">
                <i class="bi bi-chevron-left"></i>
            </button>
        </div>
        
    </div>

    <!-- Sidebar Add Film -->
    
    <c:if test="${sessionScope.isLoggedIn}">
	<div class="top-sidebar-container">
	    <div class="sidebar">
	        <h3>Add Your Movie</h3>
	        <p>Share your work with our audience. Our team will review your submission.</p>
	        <button class="btn btn-danger w-100" onclick="window.location.href='listeFilm.jsp';">Add Movie</button>
	    </div>
	</div>
	</c:if>
    <!-- Register Modal -->
    <div class="modal fade" id="registerModal" tabindex="-1" aria-labelledby="registerModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content register-card">
            <div class="modal-header border-0">
                <h5 class="modal-title w-100 text-center text-white" id="registerModalLabel">Create an Account</h5>
                <button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="controleur" method="post">
                    <div class="mb-3">
                        <label for="registerName" class="form-label">Name:</label>
                        <input type="text" class="form-control" id="registerName" name="name" placeholder="Your name" required>
                    </div>
                    <div class="mb-3">
                        <label for="registerPassword" class="form-label">Password:</label>
                        <input type="password" class="form-control" id="registerPassword" name="password" placeholder="Password" required>
                    </div>
                    <button type="submit" class="btn btn-light w-100" name="action" value="register">Register</button>
                </form>
            </div>
        </div>
    </div>
</div>

    <!-- Footer -->
    <div class="footer">
        <p>&copy; 2025 TfarejTV Reservation. Tous droits réservés.</p>
    </div>
</div>

<script>
    function scrollHorizontally(offset) {
        document.querySelector('.movies-carousel').scrollBy({ left: offset, behavior: 'smooth' });
    }
    const controls = document.querySelectorAll('.carousel-control');
    const moviesSection = document.querySelector('.movies-section');
    moviesSection.addEventListener('mouseenter', () => controls.forEach(c => c.style.opacity = '1'));
    moviesSection.addEventListener('mouseleave', () => controls.forEach(c => c.style.opacity = '0.5'));
    document.querySelector('.movies-carousel').addEventListener('wheel', function(e) {
    if (e.deltaY !== 0) {
        e.preventDefault();
        this.scrollLeft += e.deltaY * 0.5; /* Adjust multiplier for speed */
    }
});
</script>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
