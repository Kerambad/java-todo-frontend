import React from 'react';
import './App.css';

function App() {
  return (
  const [characters, setCharacters] = useState<Character[]>([])

  const updateCharacters = useCallback((newArray:Character[]) => {
        setCharacters((c) => [...c, ...newArray]);}
      , [characters])

  useEffect(() => {
    for (let i =1; i <= 13; i++) {
      axios.get("https://rickandmortyapi.com/api/character?page=" + i )
          .then((response) => {
            return response.data
          })
          .then((data) => setCharacters(data.results))
          .catch((error) => console.error())
    }}, [])
  return (
      <div className="App-header">
        <CharacterGallery characterList={characters}/>
      </div>
  );
}

export default App;
