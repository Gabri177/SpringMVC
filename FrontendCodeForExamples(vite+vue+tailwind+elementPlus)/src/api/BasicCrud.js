import axio from "../axios";

export function addUser(data) {
  return axio.post("/users", data);
}

export function getAllUser() {
  return axio.get("/users");
}

export function getUserById(id) {
	  return axio.get(`/users/id/${id}`);
}

export function getUserByName(name) {
	  return axio.get(`/users/name/${name}`);
}

export function updateUser(data) {
	  return axio.put(`/users`, data);
}

export function removeUser(id) {
	  return axio.delete(`/users/${id}`);
}