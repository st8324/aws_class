// api.js
const API_BASE_URL = '';

export const authenticatedFetch = async (endpoint, options = {}) => {
  const token = localStorage.getItem('accessToken');

  // 기존 headers에 Authorization 추가
  const headers = {
    'Content-Type': 'application/json',
    ...options.headers,
  };

  if (token) {
    headers['Authorization'] = `Bearer ${token}`;
  }

  const response = await fetch(`${API_BASE_URL}${endpoint}`, {
    ...options,
    headers,
  });

  // 401 Unauthorized (토큰 만료 등) 처리
  if (response.status === 401) {
    localStorage.removeItem('accessToken');
    window.location.href = '/login'; // 로그인 페이지로 강제 이동
  }

  return response;
};