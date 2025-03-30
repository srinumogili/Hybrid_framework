const blogPosts = [
    { title: "Best Practices for Writing Maintainable Test Automation Scripts", description: "How to write clean, reusable, and scalable automation scripts.", link: "blog1.html" },
    { title: "Common Mistakes in Automation Testing & How to Avoid Them", description: "Learn about the most common mistakes automation testers make and best practices to avoid them...", link: "blog2.html" },
    { title: "CI/CD Integration for Test Automation", description: "How to integrate automation scripts with Jenkins, GitHub Actions, and Docker for continuous testing...", link: "blog3.html" },
    { title: "Cypress vs. Selenium: Which One Should You Choose?", description: "A comparison of the two frameworks with real-world examples.", link: "blog4.html" },
    { title: "Parallel Execution in Selenium: Speeding Up Test Automation", description: "How to run tests in parallel using TestNG, Selenium Grid, or Docker.", link: "blog5.html" },
    { title: "End-to-End API Automation Testing with Rest Assured", description: "How to integrate API testing with automation frameworks.", link: "blog6.html" },
    { title: "Building a Full-Fledged CI/CD Pipeline with Jenkins", description: "Step-by-step guide to integrate automation tests with Jenkins.", link: "blog7.html" },
    { title: "Automating Deployment with GitHub Actions and Docker", description: "Running Selenium tests in a containerized environment.", link: "blog8.html" },
    { title: "Integrating Selenium with Kubernetes for Scalable Testing", description: "Running automation scripts on Kubernetes clusters.", link: "blog9.html" },
    { title: "Code Quality Checks in CI/CD Pipelines: SonarQube & ESLint", description: "How to ensure automation test code follows best practices.", link: "blog10.html" },
    { title: "Real-Time Logging and Monitoring for Automation Scripts", description: "Using tools like ELK Stack, Log4j, or Grafana for test execution logs.", link: "blog11.html" }
];

function loadBlogs() {
    const blogContainer = document.getElementById("blog-container");
    blogContainer.innerHTML = "";
    blogPosts.forEach(blog => {
        const blogElement = document.createElement("div");
        blogElement.classList.add("blog-post");
        blogElement.innerHTML = `
            <h3>${blog.title}</h3>
            <p>${blog.description}</p>
            <a href="${blog.link}" class="btn">Read More</a>
        `;
        blogContainer.appendChild(blogElement);
    });
}

function filterBlogs() {
    const searchTerm = document.getElementById("search").value.toLowerCase();
    const blogContainer = document.getElementById("blog-container");
    blogContainer.innerHTML = "";
    blogPosts.filter(blog => blog.title.toLowerCase().includes(searchTerm)).forEach(blog => {
        const blogElement = document.createElement("div");
        blogElement.classList.add("blog-post");
        blogElement.innerHTML = `
            <h3>${blog.title}</h3>
            <p>${blog.description}</p>
            <a href="${blog.link}" class="btn">Read More</a>
        `;
        blogContainer.appendChild(blogElement);
    });
}

// Load blogs when the page is loaded
document.addEventListener("DOMContentLoaded", loadBlogs);
