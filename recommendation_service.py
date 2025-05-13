from fastapi import FastAPI, Query
from typing import List
from fastapi.middleware.cors import CORSMiddleware

app = FastAPI(
    title="Movie Recommendation API",
    description="Provides personalized movie recommendations",
    version="1.0.0"
)

# Allow Java app to access this microservice
app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],  # For production, limit this to your domain
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

# Dummy database (in real life, you'd use a real ML model or DB)
movie_db = {
    "action": ["John Wick", "Mad Max: Fury Road", "Die Hard", "The Dark Knight"],
    "comedy": ["The Grand Budapest Hotel", "Superbad", "Step Brothers", "The Hangover"],
    "drama": ["The Shawshank Redemption", "Forrest Gump", "The Godfather", "Parasite"],
    "sci-fi": ["Inception", "Interstellar", "Blade Runner 2049", "The Matrix"],
}

@app.get("/recommend", response_model=List[str])
def recommend_movies(genre: str = Query(..., description="Preferred movie genre")):
    genre = genre.lower()
    return movie_db.get(genre, ["No recommendations available for this genre"])
