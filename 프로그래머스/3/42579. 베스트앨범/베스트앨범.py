def solution(genres, plays):
    genres_song = {}
    genres_play = {}
    
    for i in range(len(genres)):
        if genres[i] not in genres_song:
            genres_song[genres[i]] = []
            genres_play[genres[i]] = 0
        genres_song[genres[i]].append((plays[i], i))
        genres_play[genres[i]] += plays[i]
        

    genres_play = sorted(genres_play.items(), key=lambda x: x[1], reverse=True)

    answer = []
    for genre, _ in genres_play:
        top2 = sorted(genres_song[genre], key=lambda x:(-x[0], x[1]))[:2]
        for plays, id in top2:
            answer.append(id)        
    
    return answer