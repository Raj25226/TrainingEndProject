import React, { useState, useEffect } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import '../../node_modules/bootstrap-icons/font/bootstrap-icons.css';
import AddIndent from './AddIndent';

const IndentList = () => {
  const [items, setItems] = useState([]);
  const [showAddModal, setShowAddModal] = useState(false);
  const [newItem, setNewItem] = useState({
    field1: '',
    field2: '',
    field3: '',
    field4: '',
  });

  const fetchApiData = async () => {
    try {
      const response = await fetch('http://localhost:8080/mj/indentheader');
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      const data = await response.json();
      setItems(data);
    } catch (error) {
      console.error('Error fetching data:', error);
    }
  };

  useEffect(() => {
    fetchApiData();
  }, []);

  const handleDeleteItem = (id) => {
    // Send a DELETE request to the backend API with the item's ID.
    console.log(id);
    fetch(`http://localhost:8080/mj/indentheader/${id}`, {
      method: 'DELETE',
    })
      .then((response) => {
        if (response.ok) {
          // Item deleted successfully, update the items list in the state.
          const updatedItems = items.filter((item) => item.indentHeaderId !== id);
          setItems(updatedItems);
        } else {
          console.error('Error deleting item:', response);
        }
      })
      .catch((error) => {
        console.error('Error deleting item:', error);
      });
  };

  // Replace handleEditItem with handleViewItem
  const handleViewItem = (index) => {
    // Implement view item logic here
  };

  return (
    <div className="container mt-4">
      <div className="card" style={{ marginTop: '15%' }}>
        <div className="card-header d-flex justify-content-between align-items-center">
          <h1>Indent List</h1>
          <button
            className="btn btn-success"
            onClick={() => setShowAddModal(true)}
          >
            Add
          </button>
        </div>
        <div className="card-body">
          {items.length === 0 ? (
            <h6>No Data Found</h6>
          ) : (
            <table className="table">
              <thead>
                <tr>
                  <th>UserId</th>
                  <th>Description</th>
                  <th>Netprice</th>
                </tr>
              </thead>
              <tbody>
                {items.map((item, index) => (
                  <tr key={index}>
                    <td>{item.indentHeaderId}</td>
                    <td>{item.description}</td>
                    <td>{item.netprice}</td>
                    <td>
                      <button
                        style={{ marginLeft: '5px' }}
                        onClick={() => handleDeleteItem(item.indentHeaderId)}
                      >
                        <i className="bi bi-trash"></i>
                      </button>
                      <button
                        style={{ marginLeft: '5px' }}
                        onClick={() => handleViewItem(index)}
                      >
                        <i className="bi bi-eye"></i>
                      </button>
                      <button
                        style={{ marginLeft: '5px' }}
                        onClick={() => handleEditItem(index)}
                      >
                        <i className="bi bi-pen"></i>
                      </button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          )}
        </div>
      </div>
      {showAddModal && (
        <div className="modal" tabIndex="-1" role="dialog" style={{ display: 'block' }}>
          <div className="modal-dialog" role="document">
            <div className="modal-content">
              <div className="modal-header">
                <h5 className="modal-title">Add Item</h5>
                <button
                  type="button"
                  className="close"
                  data-dismiss="modal"
                  aria-label="Close"
                  onClick={() => setShowAddModal(false)}
                >
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div className="modal-body">
                <div className="form-group">
                  <AddIndent></AddIndent>
                </div>
              </div>
            </div>
          </div>
        </div>
      )}
    </div>
  );
};

export default IndentList;
