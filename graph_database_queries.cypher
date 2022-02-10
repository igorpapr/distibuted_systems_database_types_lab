/*забрати рюзюме*/
MATCH (user:User {id: ''})-[:HAS_RESUME]->(resume)
RETURN resume;

/*забрати всі хоббі які існують в резюме*/
MATCH (resume:Resume {id: ''})-[:INCLUDES_HOBBY]->(hobby)
RETURN collect(hobby);

/*забрати всі міста, що зустрічаються в резюме*/
MATCH (resume:Resume {id: ''})-[:INCLUDES_CITY]->(city)
RETURN collect(city);

/*забрати хоббі всіх здобувачів, що мешкають в заданому місті */
MATCH (user)-[:HAS_RESUME]->(resume)-[:INCLUDES_HOBBY]->(hobby),
      (user)-[:HAS_RESUME]->(resume)-[:CITY_OF_LIVING]->(city:City {name: ''})
RETURN collect(hobby);

/*забрати всіх здобувачів, що працювали в одному закладі (заклад ми не вказуємо)*/
MATCH (user)-[:HAS_RESUME]->(resume)-[:INCLUDES_COMPANY]->(company)
RETURN company, collect(user);