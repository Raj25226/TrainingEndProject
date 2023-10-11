import React, { useState, useEffect } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css'; // Import Bootstrap CSS
import '../../node_modules/bootstrap-icons/font/bootstrap-icons.css'
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

  const handleDeleteItem = (index) => {
    const updatedItems = items.filter((item, i) => i !== index);
    setItems(updatedItems);
  };

  const handleAddItem = () => {
    // Implement add item logic here and update the API accordingly
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
            <p><h6>No Data Found</h6></p>
          ) : (
          <table className="table">
            <thead>
              <tr>
                <th>IndentHeaderId </th>
                <th>Description </th>
                <th>Netprice </th>
                {/* <th>Field 4</th> */}
                {/* <th>Actions</th> */}
              </tr>
            </thead>
            <tbody>
              {items.map((item, index) => (
                <tr key={index}>
                  <td>{item.indentHeaderId}</td>
                  <td>{item.description}</td>
                  <td>{item.netprice}</td>
                  {/* <td>{item.field4}</td> */}
                  <td>
                    <button
                      style={{ marginLeft: '5px' }}
                      onClick={() => handleDeleteItem(index)}
                    >
                      <i className="bi bi-eye"></i>
                    </button>
                    <button
                      style={{ marginLeft: '5px' }}
                      onClick={() => handleEditItem(index)}
                    >
                      <i className="bi bi-pencil-square"></i>
                    </button>
                    <button
                      style={{ marginLeft: '5px' }}
                      onClick={() => handleDeleteItem(index)}
                    >
                      <i className="bi bi-trash"></i>
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
