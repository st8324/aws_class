import { authenticatedFetch } from '../body/api';

const UserProfile = () => {
  const fetchProfile = async () => {
    const response = await authenticatedFetch('/users/me');
    if (response.ok) {
      const profile = await response.json();
      console.log("내 정보:", profile);
    }
  };

  return <button onClick={fetchProfile}>내 정보 불러오기</button>;
};

export default UserProfile;